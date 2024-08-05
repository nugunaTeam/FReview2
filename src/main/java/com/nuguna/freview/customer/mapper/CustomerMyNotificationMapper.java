package com.nuguna.freview.customer.mapper;

import com.nuguna.freview.customer.dto.response.ZzimedMeCustomerInfoDTO;
import com.nuguna.freview.customer.dto.response.ZzimedMeStoreInfoDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMyNotificationMapper {

  Integer getZzimedMeCustomersCount(@Param("userSeq") Long userSeq,
      @Param("isRead") boolean isRead);

  List<ZzimedMeCustomerInfoDTO> getZzimedMeCustomers(
      @Param("userSeq") Long userSeq, @Param("isRead") boolean isRead, @Param("offset") int offset,
      @Param("pageSize") int pageSize);

  Integer getZzimedMeStoresCount(@Param("userSeq") Long userSeq,
      @Param("isRead") boolean isRead);

  List<ZzimedMeStoreInfoDTO> getZzimedMeStores(@Param("userSeq") Long userSeq,
      @Param("isRead") Boolean isRead,
      @Param("offset") int offset, @Param("pageSize") int pageSize);

  Boolean checkExistUnReadNotification(@Param("userSeq") Long userSeq,
      @Param("notificationSeq") Long notificationSeq);

  void makeNotificationRead(@Param("notificationSeq") Long notificationSeq);
}
