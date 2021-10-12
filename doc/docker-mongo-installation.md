```shell
docker run --name mongo \
    -p 27017:27017 \
    --restart unless-stopped \
    -d mongo
```