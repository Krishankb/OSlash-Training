package org.example;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

import java.util.Arrays;
import java.util.HashSet;


public class Main {
    static AmazonDynamoDB client  = AmazonDynamoDBClientBuilder
            .standard()
            .build();
    static DynamoDB dynamoDB = new DynamoDB(client);
    static  String tableName = "PaintingData";

    public static void main(String[] args) {
        createItems();
        retrieveItems();

        updateMultipleAttributes();
        updateAddNewAttribute();
        updateExistingAttributeConditionally();

        deleteItem();
//        System.out.println("Hello world!");
    }

    private static void deleteItem() {
    }

    private static void updateExistingAttributeConditionally() {
    }

    private static void updateAddNewAttribute() {
    }

    private static void updateMultipleAttributes() {
        Table table = dynamoDB.getTable(tableName);
        try {
            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("Id",121)
                    .withUpdateExpression("set #na =: val1")
                    .withNameMap(new NameMap().with("#na","NewAttribute"))
                    .withValueMap(new ValueMap().withString(":val1", "Some value")).withReturnValues(ReturnValue.ALL_NEW);

            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
            System.out.println("printing item after updating");
            System.out.println(outcome.getItem().toJSONPretty());
        } catch (Exception e) {
            System.err.println("Failed to update the items");
            System.err.println(e.getMessage());
//            throw new RuntimeException(e);
        }
    }

    private static void retrieveItems() {
        Table table = dynamoDB.getTable(tableName);
        try{
            Item item = table.getItem("Id",120,"ID,ISBN,Title,Authors",null);
            System.out.println("Printing item after retrieving it.......");
            System.out.println(item.toJSONPretty());
        } catch (Exception e) {
            System.err.println("GetItem failed");
            System.err.println(e.getMessage());
//            throw new RuntimeException(e);
        }
    }

    private static void createItems() {
        Table table = dynamoDB.getTable(tableName);
        try {
            Item item = new Item().withPrimaryKey("ID",120).withString("Title","Book 120 Title")
                    .withString("ISBN","120-11441664")
                    .withStringSet("Authors", new HashSet<String>(Arrays.asList("Author12","Author22")))
                    .withNumber("Price",20)
                    .withString("Dimensions","8.5*11.5*.75")
                    .withNumber("Pagecount",500)
                    .withBoolean("InPublication" ,false)
                    .withString("ProductCategory","Book");
            table.putItem(item);
            item = new Item().withPrimaryKey("ID",121).withString("Title", "Book 121 Title")
                    .withString("ISBN","121-16617664")
                    .withStringSet("Authors", new HashSet<String>(Arrays.asList("Author12","Author22")))
                    .withNumber("Price",20)
                    .withString("Dimensions","8.5*11.5*.75")
                    .withNumber("Pagecount",500)
                    .withBoolean("InPublication" ,true)
                    .withString("ProductCategory","Book");
            table.putItem(item);
        } catch (Exception e) {
            System.err.println("Create items failed");
            System.err.println(e.getMessage());
//            throw new RuntimeException(e);
        }


    }
}

































































































































































