#
# Creates an API key for the (existing) scw application that has access to the (existing) registry.
# Then calls a docker login to the (existing) scaleway registry on the given server IP using that API key.
# 

if [ $# -ne 1 ]; then
    echo "Usage: $0 server_ip # The IP of the server to be logged in"
    echo "Example: $0 1.2.3.4"
    exit 1
fi

server_ip=$1

# The registry on which we docker login the server 
registry=rg.nl-ams.scw.cloud/neoworx-hdp-micorservices


# The scw application which has access to the registry
application_id=7963520b-920a-4053-967a-3940d7b11dd8


api_key=$(scw iam api-key create application-id=$application_id expires-at=+7d -o json | jq -r .secret_key)
echo "created api key $api_key, now calling docker login on $server_ip using the api key."

ssh_key_location=$(pwd)/id

ssh -i $ssh_key_location root@$server_ip "docker login $registry -u nologin --password $api_key"
