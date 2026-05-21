# CMP Book Playground

Welcome to the **CMP Book Playground**, a dedicated space for exploring and experimenting with the concepts presented in the book **"CMP for Mobile Native Developers"**.

## Overview

This repository serves as a practical companion to the book, providing a hands-on environment where native mobile developers can dive into **Compose Multiplatform (CMP)**. Unlike a finished production application, this "playground" is designed for iterative learning, testing specific APIs, and understanding the architectural shift from platform-specific UI to a unified declarative approach.

## What's Inside

The project contains various implementations and demos discussed throughout the chapters, including:

- **Declarative Layouts**: Exploration of the Compose layout system and its power in building cross-platform UIs.
- **Theming & Design Systems**: Implementation of Material Design 3 and custom theming across Android and iOS.
- **Shared Logic & State Management**: Real-world examples of sharing business logic while maintaining native performance.
- **Platform Integration**: Demonstrations of how to bridge the gap between shared code and platform-specific APIs.

## Project Structure

This is a Kotlin Multiplatform project leveraging:
- `shared/`: The core module containing the Compose Multiplatform UI and business logic.
- `androidApp/`: The Android-specific entry point and configuration.
- `iosApp/`: The iOS-specific project (Xcode) that consumes the shared framework.

## Reference Material

This repository is a subset of the official examples and experiments for the book. For the comprehensive codebase and the primary implementation of the book's project, please visit the main repository:

🔗 **[Official Book Repository: cmp-for-mobile-native-developers](https://github.com/santimattius/cmp-for-mobile-native-developers)**

---
*Developed as part of the learning journey for "CMP for Mobile Native Developers".*
