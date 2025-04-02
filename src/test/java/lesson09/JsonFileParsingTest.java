package lesson09;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonFileParsingTest {

    private static JsonNode jsonData;

    @BeforeAll
    static void setup() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        jsonData = objectMapper.readTree(new File("src/test/resources/json_example.json"));
    }

    @Test
    void testJsonData() {
        assertNotNull(jsonData);
        assertEquals("TechCorp", jsonData.get("company").asText());
        assertEquals("success", jsonData.get("status").asText());
        assertEquals(3, jsonData.get("totalUsers").asInt());

        assertNotNull(jsonData.get("timestamp"));
        assertFalse(jsonData.get("timestamp").asText().isEmpty());

        JsonNode users = jsonData.get("users");
        assertNotNull(users);
        assertEquals(3, users.size());

        assertEquals(1, users.get(0).get("id").asInt());
        assertEquals("Alice", users.get(0).get("name").asText());
        assertEquals(25, users.get(0).get("age").asInt());

        assertEquals(2, users.get(1).get("id").asInt());
        assertEquals("Bob", users.get(1).get("name").asText());
        assertEquals(30, users.get(1).get("age").asInt());

        assertEquals(3, users.get(2).get("id").asInt());
        assertEquals("Charlie", users.get(2).get("name").asText());
        assertEquals(35, users.get(2).get("age").asInt());

        JsonNode metadata = jsonData.get("metadata");
        assertNotNull(metadata);
        assertEquals("internal", metadata.get("source").asText());
        assertEquals("ChatGPT", metadata.get("generatedBy").asText());
    }
}
