package com.skt.date.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.skt.date.repository.PeopleRepository;
import com.skt.date.vo.PeopleVo;

/**
 * @author Choonghyun
 *
 */

@Repository
public class PeopleRepositoryImpl implements PeopleRepository{
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Protected Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Public Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Constructor
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Getter & Setter Method ( DI Method )
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Public Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/**
	 * 사람 만들기
	 * @return
	 */
	public List<PeopleVo>createPeople(int howmanyPeople){
		
		List<PeopleVo> result=new ArrayList<PeopleVo>();
		
		String name[] = { "철수", "민수", "영애", "민정", "충현", "교준", "성준" };
		int age[] = { 12, 32, 21, 23, 54, 44 };
		String email[] = { "ccc@bliex.com", "aaa@bliex.com", "eee@bliex.com", "kkk@bliex.com", "111@bliex.com" };
		int height[] = { 155, 180, 190, 170, 120 };
		String bodyShape[] = { "마름", "뚱뚱", "날씬", "보통", "통통" };
		String sex[] = { "남", "여" };
		String job[] ={ "간호사", "의사", "기사", "회사원", "무직", "주부" };
		String bloodType[] = { "A", "B", "AB", "O" };
		String religion[] = { "무교", "천주교", "교회", "불교" };
		String smoking[] = { "핀다", "안핀다" };
		String drink[] = { "잘마신다", "조금마신다", "1잔", "못마신다" };
		String style[] = { "세련됨", "촌시러움", "단정함" };
		
		Random random = new Random();
		//create people
		for( int i=0; i<howmanyPeople; i++ ){
			//generate
			int nameRan = random.nextInt( name.length );
			int ageRan = random.nextInt( age.length );
			int emailRan = random.nextInt( email.length );
			int heightRan = random.nextInt( height.length );
			int bodyShapeRan = random.nextInt( bodyShape.length );
			int sexRan = random.nextInt( sex.length );
			int jobRan = random.nextInt( job.length );
			int bloodTypeRan = random.nextInt( bloodType.length );
			int religionRan = random.nextInt( religion.length );
			int smokingRan = random.nextInt( smoking.length );
			int drinkRan = random.nextInt( drink.length );
			int styleRan = random.nextInt( style.length );
			
/*			PeopleVo vo = new PeopleVo();
			vo.setName( name[nameRan] );
			vo.setAge( age[ageRan] );
			vo.setEmail( email[emailRan] );
			vo.setHeight( height[heightRan] );
			vo.setBodyShape( bodyShape[bodyShapeRan] );
			vo.setSex( sex[sexRan] );
			vo.setJob( job[jobRan] );
			vo.setBloodType( bloodType[bloodTypeRan] );
			vo.setReligion( religion[religionRan] );
			vo.setSmoking( smoking[smokingRan] );
			vo.setDrink( drink[drinkRan] );
			vo.setStyle( style[styleRan] );
			result.add(vo);*/
		}
		return result;
	}
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Implement Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Override Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Protected Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

}
