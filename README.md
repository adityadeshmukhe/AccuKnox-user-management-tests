
Project Structure for [Orange HRM  Automation Framework](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login)
1.src/main/java
This contains all reusable components and business logic.
base/
BaseClass.java Initializes WebDriver, sets up browser etc.
pages/ (Page Object Model POM)
POM>XML
com.Pages---->>>
BaseClass.java
LoginPage.java
Navigate_to_Admin.java
2.src/test/java
com.TestCases---->>>
Run_Test_Cases

>>>How to run the test cases
>>>Go to Run_Test_Case class
and right click on screen and click on (Run AS)[TestNG Test]

3.Selenium Version Used
 <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.35.0</version>
</dependency>


Problem Statment 2:
2. Automated Backup Solution:---------->>>>>>>>
com.AutomatedBackup---->>>>
Application.java

3. Log File Analyzer:--------->>>>>>>>

#!/bin/bash

# ================= Configuration =================
LOG_FILE="/var/log/apache2/access.log"  # Path to your web server log
REPORT_FILE="log_summary_report.txt"

# ================= Analysis =================
echo "===== Log Analysis Report: $(date) =====" > $REPORT_FILE

# 1. Total number of requests
TOTAL_REQUESTS=$(wc -l < $LOG_FILE)
echo "Total Requests: $TOTAL_REQUESTS" >> $REPORT_FILE

# 2. Number of 404 errors
ERROR_404=$(grep ' 404 ' $LOG_FILE | wc -l)
echo "404 Errors: $ERROR_404" >> $REPORT_FILE

# 3. Top 10 requested pages
echo "Top 10 Requested Pages:" >> $REPORT_FILE
awk '{print $7}' $LOG_FILE | sort | uniq -c | sort -nr | head -10 >> $REPORT_FILE

# 4. Top 10 IP addresses with most requests
echo "Top 10 IP Addresses:" >> $REPORT_FILE
awk '{print $1}' $LOG_FILE | sort | uniq -c | sort -nr | head -10 >> $REPORT_FILE

# 5. Optional: Top 5 user agents
echo "Top 5 User Agents:" >> $REPORT_FILE
awk -F\" '{print $6}' $LOG_FILE | sort | uniq -c | sort -nr | head -5 >> $REPORT_FILE

echo "===== End of Report =====" >> $REPORT_FILE
echo "[*] Analysis completed. Report saved to $REPORT_FILE"

