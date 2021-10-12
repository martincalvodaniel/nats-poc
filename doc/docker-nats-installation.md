```shell
docker run --memory=512m --name nats \
    -p 4222:4222 \
    -p 6222:6222 \
    -p 8222:8222 \
    --restart=unless-stopped \
    -d nats -DV
```