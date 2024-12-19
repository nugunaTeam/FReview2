<img width="156" alt="image" src="https://github.com/user-attachments/assets/09515247-bdbf-421c-aaf5-d4e0baa275e1">

## **Freview?**


FReview는 리뷰가 필요한 스토어와 무상으로 제품을 제공받는 체험단을 연결해 주는 주선 사이트입니다. 

체험단은 모집글에 ‘지원’하거나 스토어의 ‘제안’을 통해 체험이 성사될 수 있습니다.

## nugunaTeam?

팀장) 최원준 (PL | 체험단 | 공통 모듈) - https://github.com/junslog
>
팀원) 김하람 (인증 | 인가) - https://github.com/ram9611
>
팀원) 윤승 (관리자 | 게시판(공지/모집/추천) | 로그 시스템) - https://github.com/seungdangdang
>
팀원) 허영롱 (스토어) - https://github.com/yeong1203

## **Description**

> **기술 스택**
> 

<img width="513" alt="image" src="https://github.com/user-attachments/assets/9e9e145f-ee6b-4e4e-8017-618f0f8449e0">

> **ERD 다이어그램**
>
<img width="2279" alt="FReview ERD" src="https://github.com/user-attachments/assets/0c41dd65-91b9-4239-b741-9767e73b8299">


> **시퀀스 다이어그램  / 유스케이스**
> 

### [ 인증 / 인가 ]

- form 인증
<img width="937" alt="image" src="https://github.com/user-attachments/assets/b2c703ef-8401-4105-8d6c-48dfbd4ae1a2">

- OAuth 인증
<img width="1017" alt="image" src="https://github.com/user-attachments/assets/1852a86d-f814-489b-b358-b9660e306cf7">

- 인가(JWT필터)
<img width="503" alt="image" src="https://github.com/user-attachments/assets/9eab4cda-7536-47ec-87fd-50591644be2c">

### [ 체험 관련 ]

- 체험 지원
- 체험 제안
- 체험 진행
<img width="503" alt="image" src="https://github.com/user-attachments/assets/a27f9be0-9392-43d6-9c26-c813284999fb">

### [ 로그 - 누계 시스템 ]

- 유저 별 찜 누계 시스템
- 게시글 좋아요 누계 시스템
- 유저 별 포인트 누계 시스템
- 노쇼 누계 시스템
- 체험완료 누계 시스템
![로그시스템](https://github.com/user-attachments/assets/403ceb3c-318b-45ea-ad15-c3daf335348b)


> **주요 기능**
> 

[**바로가기 >**](https://www.notion.so/46aa93e1533447759fd2ef43ee4a646a?pvs=21)

> **트러블 슈팅**
> 

[**바로가기 >**](https://www.notion.so/3534c70f9f7d4a89963a13955adcd793?pvs=21)


> **기능명세서**
>
[**바로가기 >**](https://www.notion.so/00ab9ef71c2d464184c43cb9a00506dd?pvs=4)
> **요구사항 명세서**
> 
[**바로가기 >**](https://www.notion.so/19502d6553c94c64bc671231dfe0cd1f?pvs=4) 
> **API 명세서**
> 
[**바로가기 >**](https://www.notion.so/928605110fa84801b960b68a7fb14e6f?pvs=4)
> **와이어 프레임**
> 

[**바로가기 >**](https://www.figma.com/design/VrXjuAdkENU6FrYOEJS6gA/Untitled?node-id=360-2&t=12guhfReAZvY0GLT-0)
>
![와](https://github.com/user-attachments/assets/af5b3db9-0a47-4e5c-87ec-e288f511c61d)


> **사용한 라이브러리**
> 

| 의존 라이브러리 | 이유 |
| --- | --- |
| MariaDB JDBC Client (mariadb-java-client) | MariaDB 데이터베이스와의 연결 및 상호작용을 위해 사용. |
| Spring Context (spring-context) | Spring 프레임워크의 핵심 기능인 IoC (Inversion of Control) 및 DI (Dependency Injection)를 제공하기 위해 사용. |
| Spring WebMVC (spring-webmvc) | 웹 애플리케이션의 MVC 구조를 구현하고, HTTP 요청을 처리하기 위해 사용. |
| Jackson Core 및 Databind (jackson-core, jackson-databind) | JSON 데이터를 파싱하고 생성하며, Java 객체와 JSON 간의 변환을 위해 사용. |
| Spring Security (spring-security-config, spring-security-web) | 애플리케이션의 보안을 강화하고 인증 및 권한 부여를 처리하기 위해 사용. |
| Spring Security OAuth2 (spring-security-oauth2) | OAuth2 프로토콜을 사용한 인증 및 권한 부여를 지원하기 위해 사용. |
| JJWT (jjwt) | JWT (JSON Web Token) 생성 및 파싱을 위해 사용. |
| AspectJ (aspectjrt, aspectjweaver) | AOP(Aspect-Oriented Programming)를 통해 로깅이나 보안 등 부가 기능을 모듈화하기 위해 사용. |
| MyBatis (mybatis, mybatis-spring) | SQL 쿼리를 Java 객체와 매핑하여 데이터베이스 작업을 쉽게 처리하기 위해 사용. |
| Hibernate Validator (hibernate-validator) | Java Bean Validation을 통해 입력 데이터의 유효성을 검증하기 위해 사용. |
| Gson (gson) | Java 객체와 JSON 간의 변환을 단순화하기 위해 사용. |
| Lombok (lombok) | Java 클래스의 보일러플레이트 코드(예: getter, setter)를 자동으로 생성하여 개발 생산성을 높이기 위해 사용. |
| SLF4J 및 Log4j (slf4j-api, slf4j-log4j12, log4j) | 애플리케이션의 로깅을 효율적으로 관리하기 위해 사용. |

> **디렉토리 구조**
> 

### Java

```jsx
.
└── com
    └── nuguna
        └── freview
            ├── OAuth
            │   ├── OAuthUserVO.java
            │   ├── controller
            │   │   ├── OAuthApiController.java
            │   │   └── OAuthController.java
            │   ├── dto
            │   │   ├── request
            │   │   │   └── GoogleUserRegistRequestDTO.java
            │   │   └── response
            │   │       └── GoogleUserInfoDTO.java
            │   └── service
            │       ├── OAuthService.java
            │       ├── OAuthUserService.java
            │       └── impl
            │           ├── OAuthServiceImpl.java
            │           └── OAuthUserServiceImpl.java
            ├── admin
            │   ├── constant
            │   │   └── ManagementPageConstant.java
            │   ├── controller
            │   │   ├── AnalysisApiController.java
            │   │   ├── CustomerManageApiController.java
            │   │   ├── ExperienceManageApiController.java
            │   │   ├── ProfileApiController.java
            │   │   ├── StoreManageApiController.java
            │   │   └── page
            │   │       └── AdminController.java
            │   ├── dto
            │   │   ├── DoneExperienceDTO.java
            │   │   ├── DoneExperienceLogDTO.java
            │   │   ├── HiddenReviewDTO.java
            │   │   ├── InterestInfoDTO.java
            │   │   ├── NoShowExperienceLogDTO.java
            │   │   ├── request
            │   │   │   ├── CustomerListRequestDTO.java
            │   │   │   ├── DeleteUserRequestDTO.java
            │   │   │   ├── EmailModifyRequestDTO.java
            │   │   │   ├── NoticeInsertRequestDTO.java
            │   │   │   ├── PasswordModifyRequestDTO.java
            │   │   │   └── StoreListRequestDTO.java
            │   │   └── response
            │   │       ├── CustomerInfoDTO.java
            │   │       ├── StoreInfoDTO.java
            │   │       └── page
            │   │           ├── AdminProfileDTO.java
            │   │           ├── CustomerManageResponseDTO.java
            │   │           ├── HiddenReviewResponseDTO.java
            │   │           ├── InterestStatsResponseDTO.java
            │   │           └── StoreManageResponseDTO.java
            │   ├── exception
            │   │   ├── TestUserDefinedException.java
            │   │   └── handler
            │   │       └── TestExceptionHandler.java
            │   ├── mapper
            │   │   ├── AdminMapper.java
            │   │   ├── DoneExperienceAccumulationMapper.java
            │   │   ├── ExperienceLogMapper.java
            │   │   ├── ExperiencePostProcessingLogMapper.java
            │   │   ├── LikeAccumulationMapper.java
            │   │   ├── LikeLogMapper.java
            │   │   ├── LikePostProcessingLogMapper.java
            │   │   ├── NoshowAccumulationMapper.java
            │   │   ├── RankPointAccumulationMapper.java
            │   │   ├── RankPointLogMapper.java
            │   │   ├── RankPostprocessingLogMapper.java
            │   │   ├── ReviewMapper.java
            │   │   ├── UserFoodTypeMapper.java
            │   │   ├── UserInterestAccumulationMapper.java
            │   │   ├── UserInterestLogMapper.java
            │   │   ├── UserInterestPostprocessingLogMapper.java
            │   │   ├── ZzimAccumulationMapper.java
            │   │   ├── ZzimLogMapper.java
            │   │   └── ZzimPostprocessingLogMapper.java
            │   ├── service
            │   │   ├── AdminService.java
            │   │   ├── ExperienceLogService.java
            │   │   ├── ExperienceService.java
            │   │   ├── InterestService.java
            │   │   ├── LikeLogService.java
            │   │   ├── PointLogService.java
            │   │   ├── ReviewService.java
            │   │   ├── UserInterestLogService.java
            │   │   ├── ZzimLogService.java
            │   │   └── impl
            │   │       ├── AdminServiceImpl.java
            │   │       ├── ExperienceServiceImpl.java
            │   │       ├── InterestServiceImpl.java
            │   │       └── ReviewServiceImpl.java
            │   └── vo
            │       ├── AdminVO.java
            │       ├── LikeAccumulationVO.java
            │       ├── LikeLogVO.java
            │       ├── PointAccumulationVO.java
            │       ├── PointLogVO.java
            │       ├── UserInterestLogVO.java
            │       ├── ZzimAccumulationVO.java
            │       └── ZzimLogVO.java
            ├── common
            │   ├── constant
            │   │   └── BoardPageConstant.java
            │   ├── controller
            │   │   ├── AuthApiController.java
            │   │   ├── AuthController.java
            │   │   ├── CommonBrandPageApiController.java
            │   │   ├── MojipApiController.java
            │   │   ├── MyPageController.java
            │   │   ├── NoticeApiController.java
            │   │   ├── PostApiController.java
            │   │   ├── RecommendationApiController.java
            │   │   ├── UserApiController.java
            │   │   └── page
            │   │       ├── MainPageController.java
            │   │       ├── MojipController.java
            │   │       ├── NoticeController.java
            │   │       └── RecommendationController.java
            │   ├── dto
            │   │   ├── InterestAccumulationDTO.java
            │   │   ├── PersonalizedUserDTO.java
            │   │   ├── TopPerformersDTO.java
            │   │   ├── request
            │   │   │   ├── CustomerSignupRequestDTO.java
            │   │   │   ├── MojipApplyRequestDTO.java
            │   │   │   ├── MojipInsertRequestDTO.java
            │   │   │   ├── MojipListRequestDTO.java
            │   │   │   ├── MojipUpdateRequestDTO.java
            │   │   │   ├── NoticeUpdateRequestDTO.java
            │   │   │   ├── PersonalizedUserRequestDTO.java
            │   │   │   ├── PostLikeRequestDTO.java
            │   │   │   ├── RecommendationFilteringRequestDTO.java
            │   │   │   ├── RecommendationListRequestDTO.java
            │   │   │   ├── RegisterCheckBusinessNumberDTO.java
            │   │   │   ├── RegisterCheckIdRequestDTO.java
            │   │   │   ├── RegisterCheckNickNameRequestDTO.java
            │   │   │   ├── RegisterRequestDTO.java
            │   │   │   ├── RegisterSendEmailRequestDTO.java
            │   │   │   ├── TopPerformersRequestDTO.java
            │   │   │   └── ZzimRequestDTO.java
            │   │   └── response
            │   │       ├── CustomerSignupResponseDTO.java
            │   │       ├── MainPageCustomerMapperDTO.java
            │   │       ├── MainPageMojipMapperDTO.java
            │   │       ├── MainPageMojipSimpleDateDTO.java
            │   │       ├── MainPageRecentGongjiMapperDTO.java
            │   │       ├── MainPageRecentGongjiSimpleDateDTO.java
            │   │       ├── MojipPostDTO.java
            │   │       ├── MojipPostDetailDTO.java
            │   │       ├── NoticePostDTO.java
            │   │       ├── PersonalizedUsersResponseDTO.java
            │   │       ├── RecommendationResponseDTO.java
            │   │       ├── RegisterCheckInfoResponseDTO.java
            │   │       ├── RegisterSendEmailResponseDTO.java
            │   │       ├── TopPerformersResponseDTO.java
            │   │       ├── ZzimResponseDTO.java
            │   │       └── page
            │   │           ├── MainPageGongjiResponseDTO.java
            │   │           ├── MainPageHotCustomerResponseDTO.java
            │   │           ├── MainPageHotMojipResponseDTO.java
            │   │           ├── MojipResponseDTO.java
            │   │           ├── NoticeDetailResponseDTO.java
            │   │           ├── NoticeResponseDTO.java
            │   │           └── RecommendationListResponseDTO.java
            │   ├── exception
            │   │   ├── IllegalAgeGroupException.java
            │   │   ├── IllegalFoodTypeException.java
            │   │   ├── IllegalTagException.java
            │   │   └── IllegalUserCodeException.java
            │   ├── mapper
            │   │   ├── CommonBrandMapper.java
            │   │   ├── InterestAccumulationMapper.java
            │   │   ├── MainPageMapper.java
            │   │   ├── MojipMapper.java
            │   │   ├── NoticeMapper.java
            │   │   ├── PostMapper.java
            │   │   ├── RecommendationMapper.java
            │   │   ├── RegisterMapper.java
            │   │   └── UserMapper.java
            │   ├── service
            │   │   ├── CommonBrandService.java
            │   │   ├── MainPageService.java
            │   │   ├── MojipService.java
            │   │   ├── NoticeService.java
            │   │   ├── PostService.java
            │   │   ├── RecommendationService.java
            │   │   ├── RegisterService.java
            │   │   ├── UserService.java
            │   │   └── impl
            │   │       ├── CommonBrandServiceImpl.java
            │   │       ├── MainPageServiceImpl.java
            │   │       ├── MojipServiceImpl.java
            │   │       ├── NoticeServiceImpl.java
            │   │       ├── PostServiceImpl.java
            │   │       ├── RecommendationServiceImpl.java
            │   │       ├── RegisterServiceImpl.java
            │   │       └── UserServiceImpl.java
            │   └── vo
            │       ├── experience
            │       │   ├── Experience.java
            │       │   ├── ExperienceCode.java
            │       │   └── ExperienceStatusCode.java
            │       ├── post
            │       │   ├── Like.java
            │       │   ├── Post.java
            │       │   └── PostCode.java
            │       ├── review
            │       │   └── ReviewStatus.java
            │       └── user
            │           ├── AgeGroup.java
            │           ├── LoginType.java
            │           ├── UserCode.java
            │           ├── UserVO.java
            │           ├── foodType
            │           │   ├── FoodDish.java
            │           │   └── FoodType.java
            │           └── tag
            │               ├── CustomerTag.java
            │               ├── StoreTag.java
            │               ├── TagItem.java
            │               └── TagType.java
            ├── customer
            │   ├── constant
            │   │   ├── CustomerMyActivityPageConstant.java
            │   │   ├── CustomerMyExperiencePageConstant.java
            │   │   ├── CustomerMyNotificationPageConstant.java
            │   │   └── CustomerReviewLogConstant.java
            │   ├── controller
            │   │   ├── CustomerMyActivityInfoApiController.java
            │   │   ├── CustomerMyBrandInfoApiController.java
            │   │   ├── CustomerMyExperienceInfoApiController.java
            │   │   ├── CustomerMyNotificationInfoApiController.java
            │   │   ├── CustomerReviewApiController.java
            │   │   └── page
            │   │       ├── CommonPageController.java
            │   │       ├── CustomerMainPageController.java
            │   │       └── CustomerMyPageController.java
            │   ├── dto
            │   │   ├── request
            │   │   │   ├── CustomerMyAgeGroupUpdateRequestDTO.java
            │   │   │   ├── CustomerMyFoodTypesUpdateRequestDTO.java
            │   │   │   ├── CustomerMyIntroduceUpdateRequestDTO.java
            │   │   │   ├── CustomerMyNicknameUpdateRequestDTO.java
            │   │   │   ├── CustomerMyReviewRegisterRequestDTO.java
            │   │   │   ├── CustomerMyReviewsRetrieveRequestDTO.java
            │   │   │   ├── CustomerMyTagsUpdateRequestDTO.java
            │   │   │   └── CustomerOtherReviewsRetrieveRequestDTO.java
            │   │   └── response
            │   │       ├── AcceptedProposalToMeInfoDTO.java
            │   │       ├── CustomerAcceptedProposalToMeInfosRetrieveResponseDTO.java
            │   │       ├── CustomerMyAcceptedApplyInfosRetrieveResponseDTO.java
            │   │       ├── CustomerMyAgeGroupUpdateResponseDTO.java
            │   │       ├── CustomerMyApplyInfosRetrieveResponseDTO.java
            │   │       ├── CustomerMyFoodTypesUpdateResponseDTO.java
            │   │       ├── CustomerMyIntroduceUpdateResponseDTO.java
            │   │       ├── CustomerMyLikedPostsRetrieveResponseDTO.java
            │   │       ├── CustomerMyNicknameUpdateResponseDTO.java
            │   │       ├── CustomerMyProfilePhotoUpdateResponseDTO.java
            │   │       ├── CustomerMyReviewRegisterResponseDTO.java
            │   │       ├── CustomerMyReviewsRetrieveResponseDTO.java
            │   │       ├── CustomerMyTagsUpdateResponseDTO.java
            │   │       ├── CustomerMyZzimedCustomersResponseDTO.java
            │   │       ├── CustomerMyZzimedStoresRetrieveResponseDTO.java
            │   │       ├── CustomerOtherReviewsRetrieveResponseDTO.java
            │   │       ├── CustomerProposalToMeInfosRetrieveResponseDTO.java
            │   │       ├── CustomerZzimedMeCustomersRetrieveResponseDTO.java
            │   │       ├── CustomerZzimedMeStoresRetrieveResponseDTO.java
            │   │       ├── MyAcceptedApplyInfoDTO.java
            │   │       ├── MyApplyInfoDTO.java
            │   │       ├── MyLikePostInfoDTO.java
            │   │       ├── MyZzimedCustomerInfoDTO.java
            │   │       ├── MyZzimedStoreInfoDTO.java
            │   │       ├── PaginationInfoResponseDTO.java
            │   │       ├── ProposalToMeInfoDTO.java
            │   │       ├── ReviewLogInfoDTO.java
            │   │       ├── ZzimedMeCustomerInfoDTO.java
            │   │       ├── ZzimedMeStoreInfoDTO.java
            │   │       └── page
            │   │           ├── CustomerBrandInfoResponseDTO.java
            │   │           ├── CustomerMyBrandPageInfoResponseDTO.java
            │   │           └── CustomerOtherBrandPageInfoResponseDTO.java
            │   ├── exception
            │   │   ├── AlreadyExistNicknameException.java
            │   │   ├── AlreadyExistProposalException.java
            │   │   ├── AlreadyExistReviewException.java
            │   │   ├── IllegalReviewException.java
            │   │   ├── IllegalReviewPageAccessException.java
            │   │   ├── IllegalUserSeqException.java
            │   │   ├── MalformedReviewUrlException.java
            │   │   └── handler
            │   │       └── CustomerApiExceptionHandler.java
            │   ├── mapper
            │   │   ├── CustomerBrandMapper.java
            │   │   ├── CustomerMyActivityMapper.java
            │   │   ├── CustomerMyExperienceMapper.java
            │   │   ├── CustomerMyNotificationMapper.java
            │   │   ├── CustomerPageMapper.java
            │   │   ├── CustomerReviewMapper.java
            │   │   ├── OtherBrandPageUtilMapper.java
            │   │   ├── UserFileMapper.java
            │   │   └── typehandler
            │   │       └── FoodTypesTypeHandler.java
            │   ├── service
            │   │   ├── CustomerMyActivityService.java
            │   │   ├── CustomerMyBrandService.java
            │   │   ├── CustomerMyExperienceService.java
            │   │   ├── CustomerMyNotificationService.java
            │   │   ├── CustomerPageService.java
            │   │   ├── CustomerReviewService.java
            │   │   ├── OtherBrandPageUtilService.java
            │   │   ├── StoreProposalService.java
            │   │   └── impl
            │   │       ├── CustomerMyActivityServiceImpl.java
            │   │       ├── CustomerMyBrandServiceImpl.java
            │   │       ├── CustomerMyExperienceServiceImpl.java
            │   │       ├── CustomerMyNotificationServiceImpl.java
            │   │       ├── CustomerPageServiceImpl.java
            │   │       ├── CustomerReviewServiceImpl.java
            │   │       ├── OtherBrandPageUtilServiceImpl.java
            │   │       └── StoreProposalServiceImpl.java
            │   ├── validation
            │   │   ├── AgeGroupValidator.java
            │   │   ├── CustomerTagsValidator.java
            │   │   ├── FoodTypeValidator.java
            │   │   ├── UrlValidator.java
            │   │   └── annotation
            │   │       ├── ValidAgeGroup.java
            │   │       ├── ValidCustomerTags.java
            │   │       ├── ValidFoodTypes.java
            │   │       └── ValidUrl.java
            │   └── vo
            │       └── TestVO.java
            ├── global
            │   ├── FileController.java
            │   ├── FileUtil.java
            │   ├── SchedulerConfig.java
            │   ├── exception
            │   │   ├── ErrorResponse.java
            │   │   ├── GlobalExceptionHandler.java
            │   │   └── IllegalPageAccessException.java
            │   └── util
            │       ├── PaginationUtil.java
            │       ├── SendMailUtil.java
            │       └── ShaUtil.java
            ├── security
            │   ├── JwtUtil.java
            │   ├── jwtfilter
            │   │   ├── CustomAccessDeniedHandler.java
            │   │   ├── JWTfilter.java
            │   │   ├── JwtAuthenticationEntryPoint.java
            │   │   ├── JwtContextHolder.java
            │   │   ├── JwtController.java
            │   │   └── service
            │   │       ├── Impl
            │   │       │   └── JwtUserServiceImpl.java
            │   │       └── JwtUserService.java
            │   ├── login
            │   │   ├── CustomAuthenticationProvider.java
            │   │   ├── CustomUserDetail.java
            │   │   ├── CustomUserDetailsService.java
            │   │   ├── FailureHandler.java
            │   │   ├── SuccessHandler.java
            │   │   ├── mapper
            │   │   │   └── LoginMapper.java
            │   │   └── service
            │   │       ├── LoginService.java
            │   │       └── impl
            │   │           └── LoginServiceImpl.java
            │   └── logout
            │       └── LogoutFilter.java
            └── store
                ├── constant
                │   ├── StoreListConstant.java
                │   └── StoreMyBrandPageContant.java
                ├── controller
                │   ├── StoreActivityApiController.java
                │   ├── StoreExperienceApiController.java
                │   ├── StoreMyBrandInfoApiController.java
                │   ├── StoreNotificationApiController.java
                │   ├── StoreOtherBrandInfoApiController.java
                │   ├── StoreProposalApiController.java
                │   ├── TestController.java
                │   └── page
                │       ├── StoreActivityPageController.java
                │       ├── StoreBrandPageController.java
                │       ├── StoreExperiencePageController.java
                │       ├── StoreMainPageController.java
                │       └── StoreNotificationPageController.java
                ├── dto
                │   ├── request
                │   │   ├── StoreHideReviewRequestDTO.java
                │   │   ├── StoreMyFoodTypesUpdateRequestDTO.java
                │   │   ├── StoreMyIntroduceUpdateRequestDTO.java
                │   │   ├── StoreMyStoreLocationUpdateRequestDTO.java
                │   │   ├── StoreMyTagsUpdateRequestDTO.java
                │   │   ├── StoreProposalToCustomerRequestDTO.java
                │   │   └── page
                │   │       ├── StoreActivityPageRequestDTO.java
                │   │       └── StoreNotificationPageRequestDTO.java
                │   └── response
                │       ├── ExperienceApplyInfoDTO.java
                │       ├── ExperienceProposalInfoDTO.java
                │       ├── ReceivedLikeInfoDTO.java
                │       ├── ReceivedZzimCustomerInfoDTO.java
                │       ├── ReceivedZzimStoreInfoDTO.java
                │       ├── SendLikeInfoDTO.java
                │       ├── SendZzimCustomerInfoDTO.java
                │       ├── SendZzimStoreInfoDTO.java
                │       ├── StoreActivityPaginationCountResponseDTO.java
                │       ├── StoreActivitySendLikeResponseDTO.java
                │       ├── StoreActivitySendZzimCustomerResponseDTO.java
                │       ├── StoreActivitySendZzimResponseDTO.java
                │       ├── StoreActivitySendZzimStoreResponseDTO.java
                │       ├── StoreActivityWrittenPostResponseDTO.java
                │       ├── StoreApplyListDTO.java
                │       ├── StoreBrandInfoResponseDTO.java
                │       ├── StoreFinalApplyListDTO.java
                │       ├── StoreFinalProposalListDTO.java
                │       ├── StoreListPaginationResponseDTO.java
                │       ├── StoreMyFoodTypesUpdateResponseDTO.java
                │       ├── StoreMyIntroduceUpdateResponseDTO.java
                │       ├── StoreMyProfileUpdateResponseDTO.java
                │       ├── StoreMyStoreLocationUpdateResponseDTO.java
                │       ├── StoreMyTagsUpdateResponseDTO.java
                │       ├── StoreNotificationExperienceApplyResponseDTO.java
                │       ├── StoreNotificationExperienceProposalResponseDTO.java
                │       ├── StoreNotificationReceivedLikeResponseDTO.java
                │       ├── StoreNotificationReceivedZzimCustomerResponseDTO.java
                │       ├── StoreNotificationReceivedZzimStoreResponseDTO.java
                │       ├── StoreOtherReviewInfosRetrieveResponseDTO.java
                │       ├── StoreOtherReviewLogInfoDTO.java
                │       ├── StorePaginationInfoResponseDTO.java
                │       ├── StoreProposalListDTO.java
                │       ├── StoreRecentMojipPostInfoDTO.java
                │       ├── StoreRecentMojipPostInfosRetrieveResponseDTO.java
                │       ├── StoreReviewInfosRetrieveResponseDTO.java
                │       ├── StoreReviewListDTO.java
                │       ├── StoreReviewLogInfoDTO.java
                │       ├── WrittenPostInfoDTO.java
                │       ├── page
                │       │   ├── StoreActivityPageResponseDTO.java
                │       │   ├── StoreApplyListResponseDTO.java
                │       │   ├── StoreFinalApplyListResponseDTO.java
                │       │   ├── StoreFinalProposalListResponseDTO.java
                │       │   ├── StoreProposalListResponseDTO.java
                │       │   └── StoreReviewListResponseDTO.java
                │       ├── postListTotalCountResponseDTO.java
                │       ├── sendLikeTotalCountResponseDTO.java
                │       ├── sendZzimCustomerTotalCountResponseDTO.java
                │       └── sendZzimStoreTotalCountResponseDTO.java
                ├── exception
                │   ├── TestUserDefinedException.java
                │   └── handler
                │       └── TestExceptionHandler.java
                ├── mapper
                │   ├── StoreActivityPageMapper.java
                │   ├── StoreBrandPageMapper.java
                │   ├── StoreExperiencePageMapper.java
                │   ├── StoreMyBrandMapper.java
                │   ├── StoreNotificationPageMapper.java
                │   ├── StoreOtherBrandMapper.java
                │   ├── StoreProposalMapper.java
                │   └── TestStoreMapper.java
                ├── service
                │   ├── StoreActivityPageService.java
                │   ├── StoreBrandPageService.java
                │   ├── StoreExperiencePageService.java
                │   ├── StoreMyBrandService.java
                │   ├── StoreNotificationPageService.java
                │   ├── StoreOtherBrandService.java
                │   ├── TestStoreService.java
                │   └── impl
                │       ├── StoreActivityPageServiceImpl.java
                │       ├── StoreBrandPageServiceImpl.java
                │       ├── StoreExperiencePageServiceImpl.java
                │       ├── StoreMyBrandServiceImpl.java
                │       ├── StoreNotificationPageServiceImpl.java
                │       ├── StoreOtherBrandServiceImpl.java
                │       └── TestServiceImpl.java
                ├── validation
                │   ├── StoreTagsValidator.java
                │   └── annotation
                │       └── ValidStoreTags.java
                └── vo
                    └── TestVO.java

```

### resources ( mapper, properties )

```jsx
.
├── googleLoginInfo.properties
├── log4j.xml
├── mappers
│   ├── admin
│   │   ├── Interest-accumulation-map.xml
│   │   ├── admin-map.xml
│   │   ├── done-experience-accumulation-map.xml
│   │   ├── experience-log-map.xml
│   │   ├── experience-postprocessing-log-map.xml
│   │   ├── hidden-review-map.xml
│   │   ├── like-accumulation-map.xml
│   │   ├── like-log-map.xml
│   │   ├── like-postprocessing-log-map.xml
│   │   ├── noshow-accumulation-map.xml
│   │   ├── rank-point-accumulation-map.xml
│   │   ├── rank-point-log-map.xml
│   │   ├── rank-point-postprocessing-log-map.xml
│   │   ├── user-food-type-map.xml
│   │   ├── user-interest-accumulation-map.xml
│   │   ├── user-interest-log-map.xml
│   │   ├── user-interest-postprocessing-log-map.xml
│   │   ├── zzim-accumulation-map.xml
│   │   ├── zzim-log-map.xml
│   │   └── zzim-postprocessing-log-map.xml
│   ├── auth
│   │   └── register
│   │       └── register-map.xml
│   ├── common
│   │   ├── common-brand-map.xml
│   │   ├── mainpage-map.xml
│   │   ├── mojip-map.xml
│   │   ├── notice-map.xml
│   │   ├── post-map.xml
│   │   ├── recommendation-map.xml
│   │   └── user-map.xml
│   ├── customer
│   │   ├── customer-brand-map.xml
│   │   ├── customer-my-activity-map.xml
│   │   ├── customer-my-experience-map.xml
│   │   ├── customer-my-notification-map.xml
│   │   ├── customer-review-map.xml
│   │   ├── other-brand-util-map.xml
│   │   ├── page
│   │   │   └── customer-page-map.xml
│   │   └── user-file-map.xml
│   ├── security
│   │   └── login-map.xml
│   └── store
│       ├── notification-pagination-count-map.xml
│       ├── page
│       │   ├── store-activity-page-map.xml
│       │   ├── store-experience-page-map.xml
│       │   └── store-notification-page-map.xml
│       ├── pagination-count-map.xml
│       ├── store-brand-page-map.xml
│       ├── store-my-brand-map.xml
│       ├── store-other-brand-map.xml
│       └── store-proposal-map.xml
├── maria.properties
├── mybatis-context.xml
├── scheduler.properties
└── sendEmail.properties

```

### JSP (webapp)

```
.
├── META-INF
│   └── context.xml
├── Readme.txt
├── WEB-INF
│   ├── spring
│   │   ├── root-context.xml
│   │   ├── security-context.xml
│   │   └── servlet-context.xml
│   └── web.xml
├── admin-analysis.jsp
├── admin-management-customer.jsp
├── admin-management-experience.jsp
├── admin-management-store.jsp
├── admin-notice-create.jsp
├── admin-personal-profile.jsp
├── boss-my-notification.jsp
├── boss-my-request.jsp
├── common-customer-recommendation.jsp
├── common-error-404.jsp
├── common-expiredtoken.jsp
├── common-findid.jsp
├── common-findpw.jsp
├── common-google-register.jsp
├── common-login-fail.jsp
├── common-login.jsp
├── common-logout.jsp
├── common-main-nonmamber.jsp
├── common-mainpage.jsp
├── common-mojip-board.jsp
├── common-mojip-detail.jsp
├── common-notice-board.jsp
├── common-notice-detail.jsp
├── common-register-check.jsp
├── common-register-fail.jsp
├── common-register.jsp
├── common-reviewer-main.jsp
├── common-store-recommendation.jsp
├── customer-brand-info.jsp
├── customer-mainpage.jsp
├── customer-my-activity-info.jsp
├── customer-my-brand-info.jsp
├── customer-my-experience-info.jsp
├── customer-my-notification-info.jsp
├── customer-my-personal-info.jsp
├── customer_main.jsp
├── footer.jsp
├── header.jsp
├── index.jsp
├── store-activity-page.jsp
├── store-brand-info.jsp
├── store-experience-page.jsp
├── store-mainpage.jsp
├── store-mojip-create.jsp
├── store-my-brand-info.jsp
├── store-notification-page.jsp
└── store_main.jsp
```

