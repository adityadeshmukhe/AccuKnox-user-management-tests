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
