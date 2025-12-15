## Create a postgres on a server

* Run ./create_ssh_keys.sh
  This will create an ssh-key in project microservices-schulung. See the keys: https://console.scaleway.com/project/ssh-keys

* Create a VM of type DEV1-S

* Run prepare_server.sh <IP> 

* Run run_postgres_docker_on_server.sh <IP>
  This will run a postgres in docker on the server. User: postgres, Password: admin

## Accessing VMs in Scaleway

This section explains how we get the participants to use the scaleway VMs. 

* Run ./create_ssh_keys.sh
  This will create an ssh-key in project microservices-schulung. See the keys: https://console.scaleway.com/project/ssh-keys

* Create X VMs. Use the Scaleway UI and explain a bit what you are doing to the participants. 

* List the server IPs and distribute them to the participants. Each group (e.g. of 2 participants) should get 1 server IP.

* Let the participants send their public SSH keys to your E-Mail. 
  Put the SSH keys to the file public_keys_participants.txt 

* Setup the VMs for the participants by running find_servers.sh. 
  Use the output of the script and run the prepare_server.sh. 
  This will:
   * Prepare the authorized_keys file on the server (it will contain the participants keys, too)
   * Install docker and docker-compose
   * Install kubectl

* Ask the participants if they can access the servers 

## Docker login

* Run the find_servers.sh again. Then loop over the server ips and run ./docker_login_server.sh <IP address> 


