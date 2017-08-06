package com.tutorial.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

@Service("idGenerator")
public class IdUserGenerator {

    private static final Logger LOGGER = LogManager.getLogger(IdUserGenerator.class);

    public BigInteger getUniqueUserID() {
        long val = -1;
        do {
            final UUID uid = UUID.randomUUID();
            final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
            buffer.putLong(uid.getLeastSignificantBits());
            buffer.putLong(uid.getMostSignificantBits());
            final BigInteger bi = new BigInteger(buffer.array());
            val = bi.longValue();
        } while (val < 0);

        BigInteger uniqueId = BigInteger.valueOf(val);
        LOGGER.debug("GENERATE Unique User ID = " + uniqueId);
        return uniqueId;
    }
}
