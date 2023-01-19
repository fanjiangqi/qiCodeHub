var modifiedHeaders = $request.headers;
modifiedHeaders['x-group'] = 'm6irew';

$done({headers : modifiedHeaders});
