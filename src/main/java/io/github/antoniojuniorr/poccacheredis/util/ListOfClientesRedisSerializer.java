package io.github.antoniojuniorr.poccacheredis.util;

import io.github.antoniojuniorr.poccacheredis.entity.Cliente;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.List;

public class ListOfClientesRedisSerializer implements RedisSerializer<List<Cliente>> {

    @Override
    public byte[] serialize(List<Cliente> list) throws SerializationException {
        return SerializationUtils.serialize((Serializable) list);
    }

    @Override
    public List<Cliente> deserialize(byte[] bytes) throws SerializationException {
        return (List<Cliente>) SerializationUtils.deserialize(bytes);
    }
}
