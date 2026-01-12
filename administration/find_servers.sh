#!/bin/bash


#
# Iterates over all scaleway zones and gets the IPs of running servers in scaleway
# project 'microservices-schulung'
#

project_id=$(scw account project list -o json | jq -r '.[] | select(.name=="microservices-schulung") | .id')


zones="fr-par-1 fr-par-2 fr-par-3 nl-ams-1 nl-ams-2 nl-ams-3 pl-waw-1 pl-waw-2 pl-waw-3"

servers=()
for zone in $zones; do
  echo "Servers in $zone:"
  servers_found=$(scw instance server list project-id=$project_id zone=$zone -o json | jq -r '.[] | objects | .public_ip | objects | .address') 
  if test -n "$servers_found"; then
    servers+=($servers_found)
    echo "$servers_found"
  fi
done

echo "Done. All servers:"
echo "$servers"
echo "#################"
echo "Use them like so:"
echo "#################"
echo "for server in ${servers[@]}; do"
echo "  ./prepare_server.sh \$server;"
echo "done"
