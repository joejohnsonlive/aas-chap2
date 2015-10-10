# get data, load and stage
# for aas-chap2
#
echo off
cd C:/Users/Joe/aas-chap2
echo %UserProfile%
if exist linkage/nul rmdir linkage /s
mkdir linkage
cd linkage

echo curl --silent --output donation.zip http://bit.ly/1Aoywaq

pause "Problem with curl file retrieval.  Manually download http://bit.ly/1Aoywaq to linkage/donation.zip, then continue"

unzip donation.zip
unzip block_*.zip

cd ..

pause "10 files called block_*.csv should be ready to go in linkage folder"
