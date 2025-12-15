#!/bin/bash


zones="fr-par-1 fr-par-2 fr-par-3 nl-ams-1 nl-ams-2 nl-ams-3 pl-waw-1 pl-waw-2 pl-waw-3"

servers=""
for zone in $zones; do
  echo "Servers in $zone:"
  servers_found=$(scw instance server list project-id=b29b0ace-8944-4542-9228-f714b394edff zone=$zone -o json | jq -r '.[] | objects | .public_ip | objects | .address') 
  servers="$servers $servers_found"
  echo "$servers_found"
done
echo "Done. All servers:"
servers=$(echo -n $servers)
echo "$servers"
echo "#################"
echo "Use them like so:"
echo "#################"
echo "for server in \"$servers\"; do"
echo "  ./prepare_server.sh \$server;"
echo "done"
