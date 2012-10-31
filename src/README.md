superDduper - Written by Vanomaly.com - Jason Sipula

/****************************************************************/

Copyright 2012 Vanomaly.com and Jason Sipula

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

/******************************************************************/

superDduper is a file-based Deduplication Utility

- Current version uses SHA2 Hashing to determine if a file is a duplicate.
- Stores file path and hashes into SQLite3 database and uses this as a reference
	for deduplication. 
- Confirms action with user prior to removing duplicate files.
