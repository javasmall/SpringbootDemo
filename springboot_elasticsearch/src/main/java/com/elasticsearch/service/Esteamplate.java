package com.elasticsearch.service;



import com.elasticsearch.pojo.dog;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Component
public class Esteamplate {
    @Autowired
    private RestHighLevelClient client;
    private int indexid=0;
    private static final Logger log= LoggerFactory.getLogger(Esteamplate.class);
    private boolean addindex(String index) throws IOException {
//

        CreateIndexRequest request = new CreateIndexRequest(index);
        CreateIndexResponse createIndexResponse = client.indices().create(request,     RequestOptions.DEFAULT);
        JSONObject jsonObject=new JSONObject(createIndexResponse);
        log.info("createIndex: " + jsonObject.toString());
        return true;
    }
    public boolean deleteIndex(String indexName) {
        DeleteIndexRequest index = new DeleteIndexRequest(indexName);
        try {
            client.indices().delete(index);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public  JSONObject addDogs(String index, String type, dog dog) throws IOException {

        GetIndexRequest request = new GetIndexRequest();
        request.indices(index);
        if(!client.indices().exists(request,RequestOptions.DEFAULT))//添加之前判断是否存在index
        {
             addindex(index);
        }

        IndexRequest indexRequest=new IndexRequest(index,type,String.valueOf(indexid++));//用自增id作为唯一index
        indexRequest.source((new JSONObject(dog)).toString(), XContentType.JSON);
        IndexResponse indexResponse=client.index(indexRequest,RequestOptions.DEFAULT);
        JSONObject jsonObject=new JSONObject(indexResponse);
        log.info("addDog: " + jsonObject.toString());
        return jsonObject;
    }

    public JSONObject searchdog(String index, String type, String detail) throws IOException {
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(QueryBuilders.matchQuery("details", detail)); // 这里可以根据字段进行搜索，must表示符合条件的，相反的mustnot表示不符合条件的
        // boolBuilder.must(QueryBuilders.matchQuery("id", tests.getId().toString()));

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(boolBuilder);

        sourceBuilder.from(0);
        sourceBuilder.size(10); // 获取记录数，默认10
        //sourceBuilder.fetchSource(new String[] { "user", "title","desc" }, new String[] {}); // 第一个是获取字段，第二个是过滤的字段，默认获取全部
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.types(type);
        searchRequest.source(sourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(new JSONObject(response).toString());
        return  new JSONObject(response);
    }
}
