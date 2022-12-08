var modifiedHeaders = $request.headers;
modifiedHeaders['x-group'] = '3eal4i';

$done({headers : modifiedHeaders});