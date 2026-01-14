# Multithreaded Java Server

A Java-based client–server application that uses multithreading to handle multiple client requests concurrently using socket programming.

## Overview
This project demonstrates how a server can handle multiple clients simultaneously by creating a separate thread for each client connection. It highlights core Java concepts such as networking, multithreading, and synchronization.

## Technologies Used
- Java
- Socket Programming
- Multithreading
- TCP/IP Networking

## How It Works
- The server listens on a specific port
- Multiple clients connect to the server
- Each client request is handled in a separate thread
- The server processes requests concurrently without blocking other clients

## How to Run

### Compile
```bash
javac Server.java
javac Client.java
