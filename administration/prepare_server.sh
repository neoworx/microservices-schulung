#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Usage: $0 <ip_of_server_to_prepare>"
    echo "Example: $0 1.2.3.4"
    exit 1
fi


ip=$1


source_folder=$(pwd)
ssh_key=$source_folder/id

user=root


echo "Prepare server $ip"

ssh-keygen -f "~/.ssh/known_hosts" -R "$ip" | echo "No need to reconfigure $ip in known_hosts"

echo "Prepare authorized_keys file"
ssh -o StrictHostKeyChecking=no -i $ssh_key  $user@$ip "cat /root/.ssh/authorized_keys" > ./authorized_keys
echo "" >> ./authorized_keys
cat ./public_keys_participants.txt >> ./authorized_keys

scp -o StrictHostKeyChecking=no -i $ssh_key $source_folder/authorized_keys $user@$ip:/root/authorized_keys
scp -o StrictHostKeyChecking=no -i $ssh_key $source_folder/_server_init.sh $user@$ip:/_server_init.sh
ssh -o StrictHostKeyChecking=no -i $ssh_key $user@$ip "/_server_init.sh"


