package com.apec.pos.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.apec.pos.Dto.copy.TypeDto.AddTypeRequest;
import com.apec.pos.Dto.copy.TypeDto.TypeResponseAdmin;
import com.apec.pos.Dto.copy.TypeDto.TypefoodResponseData;
import com.apec.pos.Dto.copy.TypeDto.UpdateTypeRequest;
import com.apec.pos.entity.TypeFoodEntity;
import com.apec.pos.repository.TypeFoodRepository;
import com.apec.pos.service.serviceInterface.TypeFoodInterface;

@Service
public class TypeFoodService extends BaseService<TypeFoodRepository, TypeFoodEntity, Integer> implements TypeFoodInterface{

	@Autowired
	private TypeFoodRepository typeFoodRepository;
	
	@Override
	public TypefoodResponseData addTypeFood(AddTypeRequest addTypeRequest) {
		TypeFoodEntity typeFoodEntity = new TypeFoodEntity();
			typeFoodEntity.setImgType(addTypeRequest.getImgType());
			typeFoodEntity.setNameType(addTypeRequest.getNameType());
		TypeFoodEntity typeFoodEntity2 = typeFoodRepository.insert(typeFoodEntity);
		TypefoodResponseData typefoodResponseData = new TypefoodResponseData();
			typefoodResponseData.setCreateAt(typeFoodEntity2.getCreateDate());
			typefoodResponseData.setCreateBy(typeFoodEntity2.getCreateBy());
			typefoodResponseData.setId(typeFoodEntity2.getId());
			typefoodResponseData.setImgType(typeFoodEntity2.getImgType());
			typefoodResponseData.setNameType(typeFoodEntity.getNameType());
			typefoodResponseData.setStatus(typeFoodEntity.getStatus());
		return typefoodResponseData;
	}
	
	@Override
	TypeFoodRepository getRepository() {
		// TODO Auto-generated method stub
		return typeFoodRepository;
	}	
	
	public TypeResponseAdmin paging(int pageSize,int pageIndex){
		PageRequest pageRequest =  PageRequest.of(pageIndex, pageSize);
		TypeResponseAdmin typeResponseAdmin = new TypeResponseAdmin();
		List<TypefoodResponseData> typefoodResponseDatas = new ArrayList<>();
		for (TypeFoodEntity x : typeFoodRepository.paging(pageRequest)) {
			TypefoodResponseData temp = new TypefoodResponseData(); 
			temp.setCreateAt(x.getCreateDate());
			temp.setCreateBy(x.getCreateBy());
			temp.setId(x.getId());
			temp.setImgType(x.getImgType());
			temp.setNameType(x.getNameType());
			temp.setStatus(x.getStatus());
			typefoodResponseDatas.add(temp);
		}
		typeResponseAdmin.setData(typefoodResponseDatas);
		typeResponseAdmin.setTotalRow((int) (typeFoodRepository.countAll()));
		return typeResponseAdmin;
	}

	@Override
	public TypefoodResponseData updateTypeFood(UpdateTypeRequest updateTypeRequest) {
		TypeFoodEntity typeFoodEntity = typeFoodRepository.findOne(updateTypeRequest.getId());
			if(updateTypeRequest.getNameType()!=null)
				typeFoodEntity.setNameType(updateTypeRequest.getNameType());
			if(updateTypeRequest.getImgFood()!=null)
				typeFoodEntity.setImgType(updateTypeRequest.getImgFood());
			
		TypeFoodEntity typeFoodEntity2 = typeFoodRepository.update(typeFoodEntity);
		TypefoodResponseData typefoodResponseData = new TypefoodResponseData();
			typefoodResponseData.setCreateAt(typeFoodEntity2.getCreateDate());
			typefoodResponseData.setCreateBy(typeFoodEntity2.getCreateBy());
			typefoodResponseData.setId(typeFoodEntity2.getId());
			typefoodResponseData.setImgType(typeFoodEntity2.getImgType());
			typefoodResponseData.setNameType(typeFoodEntity.getNameType());
			typefoodResponseData.setStatus(typeFoodEntity.getStatus());
		return typefoodResponseData;
	}

	@Override
	public TypefoodResponseData updateStatusType(Integer id,Boolean status) {
		TypeFoodEntity typeFoodEntity = typeFoodRepository.findOne(id);
					   typeFoodEntity.setStatus(status);
		TypeFoodEntity typeFoodEntity2= typeFoodRepository.update(typeFoodEntity);		
		TypefoodResponseData typefoodResponseData = new TypefoodResponseData(typeFoodEntity2.getId(),typeFoodEntity2.getStatus(),typeFoodEntity2.getNameType(),typeFoodEntity2.getImgType(),typeFoodEntity2.getCreateDate(),typeFoodEntity2.getCreateBy());
		return typefoodResponseData;
	}

	@Override
	public String deleteType(Integer id) {
		typeFoodRepository.delete(id);		
		return "Đã Xóa";
	}
	
	
	public Set<Integer> MultiDelete(Set<Integer> ids){	
		for (Integer x : ids) {
			typeFoodRepository.delete(x);
		}
		return ids;
	}

}
