package io.advantageous.qbit.spi;

import io.advantageous.qbit.http.HttpClient;

/**
 * Created by rhightower on 11/13/14.
 */
public interface HttpClientFactory {
    HttpClient create(String host, int port, int requestBatchSize,
                      int timeOutInMilliseconds, int poolSize,
                      boolean autoFlush, int flushRate,
                      boolean keepAlive, boolean pipeLine);
}