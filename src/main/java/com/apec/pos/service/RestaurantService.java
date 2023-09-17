package com.apec.pos.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.apec.pos.dto.ToppingDTO.Item;
import com.apec.pos.dto.ToppingDTO.*;
import com.apec.pos.dto.ToppingDTO.ToppingRequest;
import com.apec.pos.dto.restaurantDto.ResponsePaging;
import com.apec.pos.entity.ToppingEntity;
import com.apec.pos.repository.FoodRepository;
import com.apec.pos.repository.ToppingRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.apec.pos.dto.restaurantDto.ResRecommnedRespon;
import com.apec.pos.dto.restaurantDto.ResRequest;
import com.apec.pos.dto.restaurantDto.SearchForm;
import com.apec.pos.entity.RestaurantEntity;
import com.apec.pos.repository.RestaurantRepository;
import com.apec.pos.service.serviceInterface.RestaurantInterface;

@Service
public class RestaurantService extends BaseService<RestaurantRepository, RestaurantEntity, Integer> implements RestaurantInterface {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ToppingRepository toppingRepository;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private FoodRepository foodRepository;

    @Override
    RestaurantRepository getRepository() {
        // TODO Auto-generated method stub
        return restaurantRepository;
    }

    @Override
    public RestaurantEntity addRestaurant(ResRequest request) {


        RestaurantEntity restaurantEntity = new RestaurantEntity();
        restaurantEntity.setRestaurantName(request.getRestaurantName());
        restaurantEntity.setAddress(request.getAddress());
        restaurantEntity.setDetail(request.getDetail());
        restaurantEntity.setPhoneNumber(request.getPhoneNumber());
        restaurantEntity.setTimeStart(request.getTimeStart());
        restaurantEntity.setTimeClose(request.getTimeClose());
        restaurantEntity.setStar(5.0);
        if (request.getImgRes() != null) {
            String imgRes = null;
            try {
                imgRes = fileUploadService.uploadFile(request.getImgRes().getBytes());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            restaurantEntity.setImgRes(imgRes);
        }
        restaurantEntity.setDistance(request.getDistance());
        RestaurantEntity result = restaurantRepository.insert(restaurantEntity);

        return result;
    }

    @Override
    public List<ResRecommnedRespon> getRecommendRes() {
        List<RestaurantEntity> restaurantEntities = restaurantRepository.getRecommendRes();
        List<ResRecommnedRespon> resRecommnedRespons = new ArrayList<>();
        for (RestaurantEntity x : restaurantEntities) {
            ResRecommnedRespon temp = new ResRecommnedRespon(x.getId(), x.getRestaurantName(), x.getQuantitySold(), x.getDistance(), x.getPhoneNumber(), x.getAddress(), x.getImgRes());

            Gson gson = new Gson();
            List<ToppingResponse> toppingResponses = new ArrayList<>();
            for (ToppingEntity y:x.getToppingEntityList()
            ) {
                ToppingResponse toppingResponse= ToppingResponse.builder()
                        .id(y.getId())
                        .title(y.getTitle())
                        .requi(y.getRequi())
                        .itemList(gson.fromJson(y.getItems(),new TypeToken<List<Item>>(){}.getType()))
                        .build();
                toppingResponses.add(toppingResponse);
            }

            temp.setTime(x.getTime());
            temp.setDetail(x.getDetail());
            temp.setStar(x.getStar());
            temp.setTimeClose(x.getTimeClose());
            temp.setTimeStart(x.getTimeStart());
            temp.setToppingEntityList(toppingResponses);
            resRecommnedRespons.add(temp);
        }
        return resRecommnedRespons;
    }

    @Override
    public RestaurantEntity getResdetail(Integer id) {
        // TODO Auto-generated method stub
        return restaurantRepository.findOne(id);
    }

    @Override
    public List<SearchForm> searchRes(String key) {
        List<RestaurantEntity> restaurantEntities = restaurantRepository.searchRes(key);
        List<SearchForm> searchRes = new ArrayList();
        for (RestaurantEntity x : restaurantEntities) {
            SearchForm searchRess = new SearchForm();
            searchRess.setId(x.getId());
            searchRess.setTitle(x.getRestaurantName());
            searchRes.add(searchRess);
        }

        return searchRes;
    }

    @Override
    public ResRecommnedRespon updateRes(ResRequest request) {
        RestaurantEntity restaurantEntity = restaurantRepository.findOne(request.getId());
        ResRecommnedRespon recommnedRespon = new ResRecommnedRespon();
        if (request.getAddress() != null)
            restaurantEntity.setAddress(request.getAddress());
        if (request.getDetail() != null)
            restaurantEntity.setDetail(request.getDetail());
        if (request.getDistance() != null)
            restaurantEntity.setDistance(request.getDistance());
        if (request.getImgRes() != null) {
            String imgRes = null;

            try {
                imgRes = fileUploadService.uploadFile(request.getImgRes().getBytes());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            restaurantEntity.setImgRes(imgRes);
        }
        if (request.getPhoneNumber() != null)
            restaurantEntity.setPhoneNumber(request.getPhoneNumber());
        if (request.getQuantitySold() != null)
            restaurantEntity.setQuantitySold(request.getQuantitySold());
        if (request.getRestaurantName() != null)
            restaurantEntity.setRestaurantName(request.getRestaurantName());
        if (request.getTimeClose() != null)
            restaurantEntity.setTimeClose(request.getTimeClose());
        if (request.getTimeStart() != null)
            restaurantEntity.setTimeStart(request.getTimeStart());

        restaurantEntity = restaurantRepository.update(restaurantEntity);
        recommnedRespon.setAddress(restaurantEntity.getAddress());
        recommnedRespon.setDistance(restaurantEntity.getDistance());
        recommnedRespon.setId(restaurantEntity.getId());
//			recommnedRespon.setImgRes();
        return null;
    }

    @Override
    public Set<Integer> deleteRes(Set<Integer> ids) {
        for (Integer x : ids) {
            for (int y:ids
                 ) {
                foodRepository.deleteWhereRestaurantId(y);
            }
            toppingRepository.deleteByResId(x);
            restaurantRepository.delete(x);
        }
        return null;
    }

    @Override
    public ResponsePaging paging(Integer pageSize, Integer pageIndex) {
        Gson gson= new Gson();
        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);
        List<ResRecommnedRespon> result = new ArrayList<>();
        List<RestaurantEntity> restaurantEntities = restaurantRepository.paging(pageRequest);
        for (RestaurantEntity x : restaurantEntities
        ) {
            //convert topping
            List<ToppingResponse> toppingResponses = new ArrayList<>();
            for (ToppingEntity y:x.getToppingEntityList()
                 ) {
                ToppingResponse toppingResponse= ToppingResponse.builder()
                        .id(y.getId())
                        .title(y.getTitle())
                        .requi(y.getRequi())
                        .itemList(gson.fromJson(y.getItems(),new TypeToken<List<Item>>(){}.getType()))
                        .build();
                toppingResponses.add(toppingResponse);
            }

            ResRecommnedRespon temp = new ResRecommnedRespon();
            temp.setAddress(x.getAddress());
            temp.setId(x.getId());
            temp.setRestaurantName(x.getRestaurantName());
            temp.setDistance(x.getDistance());
            temp.setPhoneNumber(x.getPhoneNumber());
            temp.setQuantitySold(x.getQuantitySold());
            temp.setImgRes(x.getImgRes());
            temp.setTime(x.getTime());
            temp.setDetail(x.getDetail());
            temp.setTimeStart(x.getTimeStart());
            temp.setTimeClose(x.getTimeClose());
            temp.setStar(x.getStar());
            temp.setToppingEntityList(toppingResponses);
            result.add(temp);
        }
        ResponsePaging responsePaging = new ResponsePaging();
        responsePaging.setTotalRow(restaurantRepository.countAll());
        responsePaging.setResponList(result);
        return responsePaging;
    }
}
