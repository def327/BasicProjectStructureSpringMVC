package com.tutorial.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

@Service("idGenerator")
public class IdUserGenerator {

    public static final int RANDOM_START_VALUE = -1;
    public static final int BUFFER_SIZE = 16;
    public static final int ZERO_VALUE = 0;

    private static final Logger LOGGER = LogManager.getLogger(IdUserGenerator.class);

    public BigInteger getUniqueUserID() {
        long val = RANDOM_START_VALUE;
        do {
            final UUID uid = UUID.randomUUID();
            final ByteBuffer buffer = ByteBuffer.wrap(new byte[BUFFER_SIZE]);
            buffer.putLong(uid.getLeastSignificantBits());
            buffer.putLong(uid.getMostSignificantBits());
            final BigInteger bi = new BigInteger(buffer.array());
            val = bi.longValue();
        } while (val < ZERO_VALUE);

        BigInteger uniqueId = BigInteger.valueOf(val);
        LOGGER.debug("GENERATE Unique User ID = " + uniqueId);
        return uniqueId;
    }
}
