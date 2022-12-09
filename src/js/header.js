var modifiedHeaders = $request.headers;
modifiedHeaders['x-group'] = 'hrsk8v';

$done({headers : modifiedHeaders});