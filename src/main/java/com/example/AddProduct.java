package com.example;

import com.example.kibo.KiboResourceManager;
import com.example.model.Context;
import com.mozu.api.resources.commerce.catalog.admin.ProductResource;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class AddProduct implements Function<Context, Integer> {

    @Autowired
    KiboResourceManager kiboResourceManager;

    @SneakyThrows
    @Override
    public Integer apply(Context context) {
        ProductResource productResource = kiboResourceManager.getProductResource(context);
        String s = System.getenv("AZURE_FUNCTIONS_ENVIRONMENT");
        System.out.println(s);
        Integer p = productResource.getProduct("2610").getProductTypeId();
        return p;
    }
}
