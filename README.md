# 🏢🛒  Slot Generator for Apartment - COVID-Safe Grocery Scheduling

## 📝 Problem Statement

During COVID-19, a 720-apartment community required a fair, low-contact system for accessing the on-site grocery shop. The **Slot Generator** provides each flat with a **30-minute** entry window between **07:00 and 17:00**. Residents are allowed to queue **only within their assigned slot**.

## 📋 Assumptions & Rules

- Expect **≤ 50%** of residents to shop on any given day. If turnout exceeds this, customers are admitted on a **first-come, first-served** basis within their slot.
- Parameters such as shop hours, slot length, and turnout assumptions should be **easily configurable**.
- Output should generate a **CSV-ready schedule** (with placeholders like `day1`, `day2` that can be replaced with actual dates).

## 🗒️ Notes

- The initial version is a simple, **non-optimized** Java implementation.
- Code can be run in an online editor (e.g., **OnlineGDB**) by copy-paste execution.

---

---

🚀

# Project Guide

## ▶️ How to Run the Code

This project requires no local IDE setup.

1. Copy the Java source code.
2. Open **OnlineGDB**: [https://www.onlinegdb.com/online_java_compiler](https://www.onlinegdb.com/online_java_compiler)
3. Paste the code, press **Run**, and view the console output.

## 📄 Result

- Copy the console output into a **.csv** file.
- Open it in **Excel** or another spreadsheet tool for formatting.
- Replace `day1`, `day2`, … with actual **calendar dates**.

## 🛠️ TODO

- Parameterize shop hours, slot duration, and capacity assumptions.
- Improve coding standards and documentation.
- Add input validation and error handling.
- Provide unit tests and example CSV outputs.

## 👤 Author

**Bhavani Polimetla**
Date: March 2020

## 📄 License

This project is licensed under the **Apache License 2.0**.
See the `LICENSE` file or [https://www.apache.org/licenses/LICENSE-2.0](https://www.apache.org/licenses/LICENSE-2.0).
