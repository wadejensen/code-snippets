while 1; do
  running_apps = $(curl -k -s \
	  --netrc-file secret \
	  https://yarn.cluster.company.com.au:8090/ws/v1/cluster/apps | \
	  jq '.apps.app[] | select(.queue=="root.queue0" or .queue=="root.queue1") | select(.state=="RUNNING") | .id')
	  
  for app_id in $running_apps; do yarn application -kill $app_id; done
  sleep 10
done
