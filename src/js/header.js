var modifiedHeaders = $request.headers;
modifiedHeaders['MY_HEADER'] = 'abc123';

$done({headers : modifiedHeaders});