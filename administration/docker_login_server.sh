if [ $# -ne 1 ]; then
    echo "Usage: $0 server_ip # The IP of the server to be logged in"
    echo "Example: $0 1.2.3.4"
    exit 1
fi


server_ip=$1
api_key=$(scw iam api-key create application-id=7963520b-920a-4053-967a-3940d7b11dd8 expires-at=+7d -o json | jq -r .secret_key)
echo "created api key $api_key, now logging in on $server_ip"

ssh_key_location=$(pwd)/id

ssh -i $ssh_key_location root@$server_ip "docker login rg.nl-ams.scw.cloud/neoworx-hdp-micorservices -u nologin --password $api_key"
