#!/bin/bash


install_git_server() {

  echo "################# Installing git server ##############"
  # Git-Benutzer mit korrektem Home anlegen
  sudo adduser --system --shell /usr/bin/git-shell --group --disabled-password --home /home/git git

  # Home-Verzeichnis komplett zuweisen
  sudo chown -R git:git /home/git
  sudo chmod 755 /home/git

  # SSH-Setup
  sudo mkdir -p /home/git/.ssh
  sudo cp /root/authorized_keys /home/git/.ssh/ 2>/dev/null || true
  sudo chown -R git:git /home/git/.ssh
  sudo chmod 700 /home/git/.ssh
  sudo chmod 600 /home/git/.ssh/authorized_keys

  # Repository als git-Benutzer erstellen
  sudo mkdir -p /git
  sudo chown git:git /git
  sudo -u git bash -c '
    cd /git
    mkdir microservice-schulung.git
    cd microservice-schulung.git
    git init --bare
    chmod -R ug+rwx,o-rwx /git
    git clone /git/microservice-schulung.git /home/git/microservice-schulung
  '


  git config --global --add safe.directory /git/microservice-schulung.git
  git clone /git/microservice-schulung.git /root/microservice-schulung
}

cp /root/authorized_keys /root/.ssh/authorized_keys
chmod 600 /root/.ssh/authorized_keys


sudo apt-get update

install_docker() {
  echo "################# Installing docker ##############"
  sudo apt-get -y install docker.io
  sudo apt-get -y install docker-compose
}


install_kubectl() {
  echo "################# Installing kubectl ##############"
  curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
  mv kubectl /usr/local/bin/
}

install_docker
install_kubectl
