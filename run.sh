#!/bin/bash

function get_port {
    local project_dir=$1

    local port=$(grep 'server.port' $project_dir/src/main/resources/application.properties | cut -d'=' -f2)

    echo $port
}

function run_service {
    local project_dir=$1
    local terminal=$2

    local port=$(get_port $project_dir)

    cd $project_dir

    $terminal -e "mvn spring-boot:run"
}

TERMINAL_CMD="gnome-terminal"

for service_dir in */; do
    run_service $service_dir $TERMINAL_CMD
done

echo "All services started."
