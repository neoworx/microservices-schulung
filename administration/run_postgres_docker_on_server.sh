#!/bin/bash

SERVER_IP=$1

ssh_key_location=$(pwd)/id

ssh \
  -o StrictHostKeyChecking=no \
  -i $ssh_key_location \
  root@$SERVER_IP \
  "docker run --network host -d --name my_postgres -v /postgres_data:/var/lib/postgresql -e POSTGRES_PASSWORD=admin postgres:latest"
