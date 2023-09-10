package com.apec.pos.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.apec.pos.dto.FoodDto.AddMultipartFood;
import com.apec.pos.dto.ToppingDTO.ToppingRequestAdd;
import com.apec.pos.entity.ToppingEntity;
import com.apec.pos.repository.ToppingRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.apec.pos.dto.FoodDto.AddFoodRequest;
import com.apec.pos.dto.FoodDto.FoodRecommendDto;
import com.apec.pos.dto.FoodDto.FoodResponseAdmin;
import com.apec.pos.entity.FoodEntity;
import com.apec.pos.repository.FoodRepository;
import com.apec.pos.service.serviceInterface.FoodInterface;


@Service
@CacheConfig(cacheNames = "iotFood")
public class FoodService extends BaseService<FoodRepository, FoodEntity, Integer> implements FoodInterface {

    @Autowired
    private ToppingRepository toppingRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FileUploadService fileUploadService;

    @Override
    FoodRepository getRepository() {
        // TODO Auto-generated method stub
        return foodRepository;
    }

    @Override
    public List<FoodRecommendDto> getFoodRecommand() {
        List<FoodEntity> foodEntitys = foodRepository.getTopFood();
        System.out.println(foodEntitys.size());
        List<FoodRecommendDto> foodRecommanDtos = new ArrayList<FoodRecommendDto>();
        for (FoodEntity x : foodEntitys) {
            String nameRes = x.getRestaurantEntity().getRestaurantName();
            FoodRecommendDto temp =
                    new FoodRecommendDto(
                            x.getId(),
                            x.getFoodName(),
                            x.getPrice(),
                            x.getDetail(),
                            nameRes,
                            x.getImgFood(),
                            x.getCreateBy(),
                            x.getCreateDate(),
                            x.getQuantityPurchased(),
                            x.getTypeFoodEntityId(),
                            x.getRestaurantEntityId(),
                            x.getStatus(),
                            x.getToppingEntities()
                    );

            foodRecommanDtos.add(temp);
        }
        System.out.println(foodRecommanDtos.size());
        return foodRecommanDtos;
    }

    @Override
    public FoodRecommendDto addFood(AddFoodRequest addFoodRequest) {
        String imgFood = "";
        Gson gson = new Gson();
        List<ToppingRequestAdd> toppingRequest = gson.fromJson(addFoodRequest.getToppingRequest(),new TypeToken<List<ToppingRequestAdd>>(){}.getType());
        if (addFoodRequest.getImgFood() != null) {
            try {
                imgFood = fileUploadService.uploadFile(addFoodRequest.getImgFood().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<ToppingEntity> listToppingTemp = new ArrayList<>();
            if (toppingRequest != null) {
                for (ToppingRequestAdd x : toppingRequest
                ) {
                    ToppingEntity temp = new ToppingEntity();
                    System.out.println(temp.getName());
                    temp.setPrice(x.getPrice());
                    temp.setName(x.getName());
                    listToppingTemp.add(temp);
                }
            }
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setDetail(addFoodRequest.getDetail());
        foodEntity.setFoodName(addFoodRequest.getFoodName());
        foodEntity.setImgFood(imgFood);
        foodEntity.setPrice(addFoodRequest.getPrice());
        foodEntity.setRestaurantEntityId(addFoodRequest.getRestaurantEntityId());
        foodEntity.setTypeFoodEntityId(addFoodRequest.getTypeFoodEntityId());
        foodEntity.setToppingEntities(listToppingTemp);


        foodEntity = foodRepository.insert(foodEntity);

        FoodRecommendDto foodRecommanDto = new FoodRecommendDto();
        foodRecommanDto.setCreateAt(foodEntity.getCreateDate());
        foodRecommanDto.setCreateBy(foodEntity.getCreateBy());
        foodRecommanDto.setFoodName(foodEntity.getFoodName());
        foodRecommanDto.setPrice(foodEntity.getPrice());
        foodRecommanDto.setNameRestaurantFood(foodEntity.getFoodName());
        foodRecommanDto.setImgFood(foodEntity.getImgFood());
        foodRecommanDto.setTypeFoodEntityId(foodEntity.getTypeFoodEntityId());
        foodRecommanDto.setRestaurantEntityId(foodEntity.getRestaurantEntityId());
        foodRecommanDto.setStatus(foodEntity.getStatus());
        foodRecommanDto.setToppingEntities(foodEntity.getToppingEntities());
        return foodRecommanDto;
    }

    @Override
    public List<FoodEntity> findFoodOnType(FoodEntity foodEntity) {
        return foodRepository.findFoodOnType(foodEntity);
    }

    @Override
    public List<FoodRecommendDto> searchFood(String searchString) {
        List<FoodEntity> foodEntity = foodRepository.findFoodByKey(searchString);
        List<FoodRecommendDto> foodSearchRespons = new ArrayList<>();
        for (FoodEntity x : foodEntity) {
            String nameRes = x.getRestaurantEntity().getRestaurantName();
            Double distance = x.getRestaurantEntity().getDistance();
            FoodRecommendDto temp = new FoodRecommendDto(
                    x.getId(),
                    x.getFoodName(),
                    x.getPrice(),
                    x.getDetail(),
                    nameRes,
                    x.getImgFood(),
                    x.getCreateBy(),
                    x.getCreateDate(),
                    x.getQuantityPurchased(),
                    x.getTypeFoodEntityId(),
                    x.getRestaurantEntityId(),
                    x.getStatus(),
                    x.getToppingEntities()
            );
            foodSearchRespons.add(temp);
        }
        return foodSearchRespons;
    }

    @Override
    public FoodRecommendDto getDetailFood(Integer id) {
        FoodEntity x = foodRepository.findOne(id);
        Double distance = x.getRestaurantEntity().getDistance();
        String nameRes = x.getRestaurantEntity().getRestaurantName();
        FoodRecommendDto temp = new FoodRecommendDto(
                x.getId(),
                x.getFoodName(),
                x.getPrice(),
                x.getDetail(),
                nameRes,
                x.getImgFood(),
                x.getCreateBy(),
                x.getCreateDate(),
                x.getQuantityPurchased(),
                x.getTypeFoodEntityId(),
                x.getRestaurantEntityId(),
                x.getStatus(),
                x.getToppingEntities()
        );
        temp.setToppingEntities(x.getToppingEntities());
        return temp;
    }

    @Override
    public FoodResponseAdmin paging(int pageSize, int pageIndex) {
        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);
        List<FoodRecommendDto> foodRecommanDtos = new ArrayList<>();
        List<FoodEntity> foodEntities = foodRepository.paging(pageRequest);
        for (FoodEntity x : foodEntities) {
            FoodRecommendDto data =
                    new FoodRecommendDto(
                            x.getId(),
                            x.getFoodName(),
                            x.getPrice(),
                            x.getDetail(),
                            x.getRestaurantEntity() != null ? x.getRestaurantEntity().getRestaurantName() : "",
                            x.getImgFood(),
                            x.getCreateBy(),
                            x.getCreateDate(),
                            x.getQuantityPurchased(),
                            x.getTypeFoodEntityId(),
                            x.getRestaurantEntityId(),
                            x.getStatus(),
                            x.getToppingEntities()
                    );
            data.setStatus(x.getStatus());
            data.setCreateAt(x.getCreateDate());
            data.setCreateBy(x.getCreateBy());
            foodRecommanDtos.add(data);
        }

        FoodResponseAdmin foodResponseAdmin = new FoodResponseAdmin(foodRepository.countAll(), foodRecommanDtos);
        return foodResponseAdmin;
    }

    @Override
    public FoodRecommendDto updateFood(AddFoodRequest addFoodRequest) throws IOException {
        String imgFood = null;
        if (addFoodRequest.getImgFood() != null) {
            imgFood = fileUploadService.uploadFile(addFoodRequest.getImgFood().getBytes());
        }
        FoodEntity foodEntity = foodRepository.findOne(addFoodRequest.getId());
        if (addFoodRequest.getDetail() != null)
            foodEntity.setDetail(addFoodRequest.getDetail());
        if (addFoodRequest.getFoodName() != null)
            foodEntity.setFoodName(addFoodRequest.getFoodName());
        if (addFoodRequest.getImgFood() != null)
            foodEntity.setImgFood(imgFood);
        if (addFoodRequest.getPrice() != null)
            foodEntity.setPrice(addFoodRequest.getPrice());
        if (addFoodRequest.getRestaurantEntityId() != null)
            foodEntity.setRestaurantEntityId(addFoodRequest.getRestaurantEntityId());
        if (addFoodRequest.getRestaurantEntityId() != null)
            foodEntity.setTypeFoodEntityId(addFoodRequest.getTypeFoodEntityId());
        foodEntity = foodRepository.update(foodEntity);

        FoodRecommendDto foodRecommanDto = new FoodRecommendDto();
        foodRecommanDto.setCreateAt(foodEntity.getCreateDate());
        foodRecommanDto.setCreateBy(foodEntity.getCreateBy());
        foodRecommanDto.setFoodName(foodEntity.getFoodName());
        foodRecommanDto.setPrice(foodEntity.getPrice());
        foodRecommanDto.setNameRestaurantFood(foodEntity.getFoodName());
        foodRecommanDto.setImgFood(foodEntity.getImgFood());
        foodRecommanDto.setTypeFoodEntityId(foodEntity.getTypeFoodEntityId());
        foodRecommanDto.setRestaurantEntityId(foodEntity.getRestaurantEntityId());
        foodRecommanDto.setStatus(foodEntity.getStatus());
        foodRecommanDto.setToppingEntities(foodEntity.getToppingEntities());

        return foodRecommanDto;
    }

    @Override
    public String updateStatusFood(Integer id, Boolean status) {
        FoodEntity foodEntity = foodRepository.findOne(id);
        foodEntity.setStatus(status);
        return "Đã Sửa status";
    }

    @Override
    public String deleteFood(Integer id) {
        foodRepository.delete(id);
        return "Đã xóa";
    }

    @Override
    public List<Integer> MuiltiDelete(Set<Integer> ids) {
        List<Integer> listId = new ArrayList<>();
        for (Integer x : ids) {
            toppingRepository.deleteByFoodId(x);
            int temp = foodRepository.delete(x);
            listId.add(temp);
        }
        return listId;
    }

    @Override
    public void multipartAddFood(List<AddMultipartFood> addFoodRequests) throws IOException {
        for (AddMultipartFood x:
             addFoodRequests) {
            //
            byte[] bytes = null;
            try(var stream = new URL(x.getImgFood()).openStream()){
                 bytes = stream.readAllBytes();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String img=fileUploadService.uploadFile(bytes);
            Gson gson = new Gson();
            List<ToppingRequestAdd> toppingRequest = gson.fromJson(x.getToppingRequest(),new TypeToken<List<ToppingRequestAdd>>(){}.getType());
            List<ToppingEntity> listToppingTemp = new ArrayList<>();
            //
            if (toppingRequest != null) {
                for (ToppingRequestAdd a : toppingRequest
                ) {
                    ToppingEntity temp = new ToppingEntity();
                    temp.setPrice(a.getPrice());
                    temp.setName(a.getName());
                    listToppingTemp.add(temp);
                }
            }

            FoodEntity foodEntity = FoodEntity.builder()
                    .foodName(x.getFoodName())
                    .detail(x.getDetail())
                    .price(x.getPrice())
                    .imgFood(img)
                    .typeFoodEntityId(x.getTypeFoodEntityId())
                    .restaurantEntityId(x.getRestaurantEntityId())
                    .toppingEntities(listToppingTemp).build();
            foodRepository.insert(foodEntity);
        }

    }


}
