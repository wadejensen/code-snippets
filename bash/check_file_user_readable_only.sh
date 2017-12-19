# Test permissions on secret file
OCTAL=$(stat -c %a "$SECRET_PATH")
if ! [[ $OCTAL =~ [4-7]00 ]]; then
  echo "Your password file should be readable to user $PROJECT_USER only."
  echo "Run chmod 600 $SECRET_PATH, to make the file RW only."
  exit 1
fi
