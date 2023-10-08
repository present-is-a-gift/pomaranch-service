package com.pomaranch.shop.service;

import com.pomaranch.shop.Goods;
import com.pomaranch.shop.GoodsListRequest;
import com.pomaranch.shop.GoodsListResponse;
import com.pomaranch.shop.GoodsRequest;
import com.pomaranch.shop.GoodsServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
public class GoodsService extends GoodsServiceGrpc.GoodsServiceImplBase {
    @Override
    public void getGoodsList(GoodsListRequest request, StreamObserver<GoodsListResponse> responseObserver) {
        GoodsListResponse response = GoodsListResponse.newBuilder()
                .addAllProducts(testGoods())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getGoodsById(GoodsRequest request, StreamObserver<Goods> responseObserver) {
        Goods goods = switch ((int) request.getId()) {
            case 1 -> testGoods().get(0);
            case 2 -> testGoods().get(1);
            case 3 -> testGoods().get(2);
            default -> null;
        };

        responseObserver.onNext(goods);
        responseObserver.onCompleted();
    }

    private List<Goods> testGoods() {
        return List.of(
                Goods.newBuilder()
                        .setId(1)
                        .setName("T-Shirt")
                        .build(),
                Goods.newBuilder()
                        .setId(2)
                        .setName("Hoody")
                        .build(),
                Goods.newBuilder()
                        .setId(3)
                        .setName("Jacket")
                        .build()
        );
    }
}
