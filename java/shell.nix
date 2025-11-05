{ pkgs ? import <nixpkgs> {} }:

pkgs.mkShell {
  buildInputs = [
    pkgs.openjdk17   # change to openjdk8, openjdk21, etc. if needed
  ];
}
