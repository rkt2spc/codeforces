#!/bin/sh

problem_directory="$1"
template_directory="_tmpl"

if [ ! -d "$problem_directory" ]; then
  cp -r "$template_directory" "$problem_directory"
fi
