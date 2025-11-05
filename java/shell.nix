{ pkgs ? import <nixpkgs> {} }:

pkgs.mkShell {
  buildInputs = [
    pkgs.openjdk17   # change to openjdk8, openjdk21, etc. if needed
  ];
}

# this message is for person having birthday 3 march or 6 march may be i am not sure its been 5 year i dont remember exactly
# can you recommend better option then nix OS i by mistakely currepted my java compiler
# please make an issue in my github with possible solution