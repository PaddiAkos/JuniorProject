package hu.demo.junior.jpa.exception;

import java.util.Map;
import java.util.stream.Collectors;

public class EntityNotFoundException extends CommonException
{
    public EntityNotFoundException(Class<?> entityClass, Map<String, String> searchPropertyMap)
    {
        super(String.format("Entity %s not found with parameters %s", entityClass.getSimpleName(), mapToString(searchPropertyMap)), true);
    }

    private static String mapToString(Map<String, String> searchPropertyMap) {
        if(searchPropertyMap == null) {
            return null;
        }

        return searchPropertyMap.entrySet().stream()
                .map(entry -> String.format("%s=%s", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));
    }
}
