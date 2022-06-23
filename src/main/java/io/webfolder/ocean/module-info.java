module io.webfolder.ocean {
  requires java.logging;
  requires java.net.http;
  requires jsr305;
  requires com.fasterxml.jackson.annotation;
  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.databind;
  requires com.fasterxml.jackson.datatype.jsr310;
  exports io.webfolder.ocean.api;
  exports io.webfolder.ocean.model;
  exports io.webfolder.ocean.client;
}
