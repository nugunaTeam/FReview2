package com.nuguna.freview.common.vo.user.foodType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum FoodDish {
  GUKBAB("국밥", FoodType.KOREAN),
  TONKATSU("돈까스", FoodType.KOREAN),
  JOKBAL("족발", FoodType.KOREAN),
  MAKCHANG("막창", FoodType.KOREAN),
  PIZZA("피자", FoodType.WESTERN),
  PASTA("파스타", FoodType.WESTERN),
  HAMBURGER("햄버거", FoodType.WESTERN),
  STEAK("스테이크", FoodType.WESTERN),
  MALATANG("마라탕", FoodType.CHINESE),
  JJAJANGMYEON("짜장면", FoodType.CHINESE),
  JJAMPPONG("짬뽕", FoodType.CHINESE),
  TANGSOOYOOK("탕수육", FoodType.CHINESE),
  TENDON("텐동", FoodType.JAPANESE),
  SUSHI("초밥", FoodType.JAPANESE),
  GYUDON("규동", FoodType.JAPANESE),
  RAMEN("라멘", FoodType.JAPANESE),
  BREAD("빵", FoodType.BAKERY),
  CAKE("케이크", FoodType.BAKERY),
  COOKIE("쿠키", FoodType.BAKERY),
  SANDWICH("샌드위치", FoodType.BAKERY),
  COFFEE("커피", FoodType.OTHER),
  CURRY("커리", FoodType.OTHER),
  RICE_NOODLES("쌀국수", FoodType.OTHER),
  OTHER("기타", FoodType.OTHER);

  private final String code;
  private final FoodType foodType;

  public static FoodDish fromCode(String code) {
    for (FoodDish dish : FoodDish.values()) {
      if (dish.getCode().equalsIgnoreCase(code)) {
        return dish;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 FoodDish 입력: " + code);
  }

  public static FoodDish fromFoodType(FoodType typeCode) {
    for (FoodDish dish : FoodDish.values()) {
      if (dish.getFoodType() == typeCode) {
        return dish;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 FoodTypeCode 입력: " + typeCode);
  }
}