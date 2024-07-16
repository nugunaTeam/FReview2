package com.nuguna.freview.common.vo.user.foodType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum FoodDish {
  GUKBAB("국밥", FoodType.KOREAN),
  TONKATSU("돈까스", FoodType.WESTERN),
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
  TTEOKBOKKI("떡볶이", FoodType.KOREAN),
  GYUDON("규동", FoodType.JAPANESE),
  RAMEN("라멘", FoodType.JAPANESE),
  BREAD("빵", FoodType.BAKERY),
  CAKE("케이크", FoodType.BAKERY),
  COOKIE("쿠키", FoodType.BAKERY),
  SANDWICH("샌드위치", FoodType.WESTERN),
  COFFEE("커피", FoodType.BAKERY),
  CURRY("커리", FoodType.JAPANESE),
  RICE_NOODLES("쌀국수", FoodType.WESTERN),
  OTHER("기타", FoodType.WESTERN);

  private final String code;
  private final FoodType typeCode;

  public static FoodDish fromCode(String code) {
    for (FoodDish dish : FoodDish.values()) {
      if (dish.getCode().equalsIgnoreCase(code)) {
        return dish;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 FoodDish 입력: " + code);
  }

  public static FoodDish fromTypeCode(FoodType typeCode) {
    for (FoodDish dish : FoodDish.values()) {
      if (dish.getTypeCode() == typeCode) {
        return dish;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 FoodTypeCode 입력: " + typeCode);
  }
}