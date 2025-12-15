#!/bin/bash

ssh_key_location=$(pwd)
ssh-keygen -t ed25519 -C “login” -Z aes256-gcm@openssh.com -f $ssh_key_location/id -N ""
scw iam ssh-key create name=ssh-key-for-training public-key="$(cat $ssh_key_location/id.pub)" project-id=b29b0ace-8944-4542-9228-f714b394edff
