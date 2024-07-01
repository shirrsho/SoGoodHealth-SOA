#!/bin/bash

function get_port {
    local project_dir=$1
    local port=$(grep 'server.port' "$project_dir/src/main/resources/application.properties" | cut -d'=' -f2)
    echo $port
}

function run_service {
    local project_dir=$1
    local terminal=$2

    local port=$(get_port "$project_dir")

    if [[ -z "$port" ]]; then
        echo "Port not found for $project_dir"
        return
    fi

    echo "Starting service in $project_dir on port $port..."

    (
        cd "$project_dir" || exit
        $terminal -- bash -c "mvn spring-boot:run; exec bash"
    )
}

TERMINAL_CMD="gnome-terminal"

for service_dir in */; do
    run_service "$service_dir" "$TERMINAL_CMD"
done

echo "All services started."
