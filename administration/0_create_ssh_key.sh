#!/bin/bash

#
# Creates an ssh key pair and adds it to the scaleway project 
# microservices-schulung
# 

project_id=$(scw account project list -o json | jq -r '.[] | select(.name=="microservices-schulung") | .id')

ssh_key_name="ssh-key-for-training-created-by-bash"

ssh_key_location=$(pwd)
ssh-keygen -t ed25519 -C “login” -Z aes256-gcm@openssh.com -f $ssh_key_location/id -N ""

existing_keys=$(scw iam ssh-key list -o json | jq -r '.[] | select(.name="'$ssh_key_name'") | .id')
for existing_key in $existing_keys; do
  scw iam ssh-key delete $existing_key
done
scw iam ssh-key create name=$ssh_key_name public-key="$(cat $ssh_key_location/id.pub)" project-id=$project_id
