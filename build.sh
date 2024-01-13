#!/usr/bin/env bash

# Builds all applications and all docker images using Dockerfile and tags it based on org.opencontainers.image.version
# label in Dockerfile.

#######################################
# Script main function. Builds all applications and all docker images using Dockerfile and tags it based on
# org.opencontainers.image.version label in Dockerfile.
# Arguments:
#   None.
#######################################
function main() {
    cd ./simple-rpg-slope/; ./build.sh; cd ..
    cd ./simple-rpg-ski-resort/; ./build.sh; cd ..
    cd ./simple-rpg-gateway/; ./build.sh; cd ..
    cd ./angular-app/; ./build.sh; cd ..
}

main "$@"
