package umc.study.converter;

import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.Store;
import umc.study.domain.mapping.ReviewStore;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewStoreConverter {
    public static ReviewStore toReviewStore(Store store) {
        return ReviewStore.builder()
                .store(store)
                .build();
    }
//    public static List<ReviewStore> toReviewStoreList(List<Store> storeList){
//
//        return storeList.stream()
//                .map(store ->
//                        ReviewStore.builder()
//                                .store(store)
//                                .build()
//                ).collect(Collectors.toList());
//    }

}
