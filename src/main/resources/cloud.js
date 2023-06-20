
const AWS = require("aws-sdk");
const dynamodb = new AWS.DynamoDB({ apiVersion: "2012-08-10" });
const tableName = process.env.COURSE_TABLE;

exports.handler = async (event) => {
    console.log("Request received: " + JSON.stringify(event));

    const method = event.httpMethod;
    const path = event.path;
    const body = JSON.parse(event.body);
    const query = event.queryStringParameters;
    const resource = event.resource;

    const notFoundMessage = {
        statusCode: 404,
        body: JSON.stringify({message: "Path not found"})
    };

    if(path === "/course") {
        switch(method) {
            case "GET":
                const items = await dynamodb.scan({ TableName: tableName }).promise();
                return {
                    statusCode: 200,
                    body: JSON.stringify({ data: items })
                };
            case "POST":
                const saveParams = {
                    TableName: tableName,
                    Item: {
                        "courseCode": { S: body.courseCode },
                        "courseName": { S: body.courseName },
                        "teacherName": { S: body.teacherName },
                        "students": { SS: body.students },
                        "month": { N: `${body.month}` },
                        "year": { N: `${body.year}` }
                    }
                };
                await dynamodb.putItem(saveParams).promise();
                return {
                    statusCode: 201,
                    body: JSON.stringify({message: "Item created"})
                };
            case "PATCH":
                const params = {
                    TableName: tableName,
                    ExpressionAttributeNames: {
                        "#AT": "month",
                        "#Y": "year"
                    },
                    ExpressionAttributeValues: {
                        ":t": { N: `${body.month}` },
                        ":y": { N: `${body.year}` }
                    },
                    Key: {
                        "courseCode": { S: body.courseCode },
                        "teacherName": { S: body.teacherName }
                    },
                    ReturnValues: "ALL_NEW",
                    UpdateExpression: "SET #Y = :y, #AT = :t"
                };
                await dynamodb.updateItem(params).promise();
                return {
                    statusCode: 200,
                    body: JSON.stringify({message: "Item is updated"})
                };
            case "DELETE":
                const deleteParams = {
                    TableName: tableName,
                    Key: {
                        "courseCode": { S: body.courseCode },
                        "teacherName": { S: body.teacherName }
                    }
                };
                await dynamodb.deleteItem(deleteParams).promise();
                return {
                    statusCode: 200,
                    body: JSON.stringify({message: "Item deleted"})
                };
            default:
                return notFoundMessage;
        }
    } else if (path === "/course/item") {
        const params = {
            TableName: tableName,
            Key: {
                "courseCode": { S: query.courseCode },
                "teacherName": { S: query.teacherName }
            }
        };
        const getCourse = await dynamodb.getItem(params).promise();

        return {
            statusCode: 200,
            body: JSON.stringify(getCourse)
        };
    } else if (resource === "/course/{courseName}") {
        const params = {
            TableName: tableName,
            IndexName: "courseName-index",
            KeyConditionExpression: "courseName = :name",
            ExpressionAttributeValues: {
                ":name": { S: event.pathParameters.courseName }
            }
        };
        const queryItem = await dynamodb.query(params).promise();

        return {
            statusCode: 200,
            body: JSON.stringify(queryItem)
        };
    }
    return notFoundMessage;
};
/*
aws cognito-idp sign-up --client-id <<app_client_id>> --username <<your_email>>
--password Test123 --user-attributes Name=email,Value=<<your_email>>
Name=name,Value=<<your_first_name>> --region us-east-1



aws cognito-idp initiate-auth --auth-flow USER_PASSWORD_AUTH --client-id 3fanpa856ms0rhqs0b0kasssko --auth-parameters USERNAME=sanjiv771+nov17@gmail.com,PASSWORD=Test1234 --region us-east-1

aws cognito-idp admin-set-user-password --user-pool-id 3fanpa856ms0rhqs0b0kasssko --username sanjiv771@gmail.com --password test123 --permanent

aws cognito-idp admin-respond-to-auth-challenge --user-pool-id us-east-1_20KtYSXY5 --client-id 3fanpa856ms0rhqs0b0kasssko --challenge-name NEW_PASSWORD_REQUIRED --challenge-responses NEW_PASSWORD=teat123,USERNAME=sanjiv771+nov17@gmail.com,userAttributes.name=Sanjiv --session "AYABeJJgxQ97ceBQFu14rn1jk_8AHQABAAdTZXJ2aWNlABBDb2duaXRvVXNlclBvb2xzAAEAB2F3cy1rbXMAS2Fybjphd3M6a21zOnVzLWVhc3QtMTo3NDU2MjM0Njc1NTU6a2V5L2IxNTVhZmNhLWJmMjktNGVlZC1hZmQ4LWE5ZTA5MzY1M2RiZQC4AQIBAHiG0oCCDoro3IaeecGyxCZJOVZkUqttbPnF4J7Ar-5byAEFT9woq_PKWmAAr-HMPth9AAAAfjB8BgkqhkiG9w0BBwagbzBtAgEAMGgGCSqGSIb3DQEHATAeBglghkgBZQMEAS4wEQQMVrtSekAFJc-APteJAgEQgDvvCgnYeUVdfY3WAUWkwHhn4tCzzb1tk1tBX4VBh4rhZASy24o2riRsaI2FsLrmpA16wvFx_YG8lewEygIAAAAADAAAEAAAAAAAAAAAAAAAAAA2vshwmBY19htpvz93nR2Z_____wAAAAEAAAAAAAAAAAAAAAEAAADaPrjWjAlsri45poaDblXmCbaH1nW3P0jxyYmGhyfuS4VeV5hWFyA9NtLi_t1-qqQxbVx3Y0zV2IMdCTbgdj6UptAod75uqrFI5ASktKOX48XEo8djSct5kutPeF7SMelPDwvuHCrOzkQx4Sigx9tuVjwFDbeK37g6Ia80TShX8zY8gLg8BRk4zjNe7oWQmBKOSEKnEBmOrhvm0oz4v24ZmO5ssWSWrX2k-AnoBsyTjeyXiPcIQK6aOyQwSYiovieWKjGm-fJCcf_-YLJyZcUZtvyZ8KPIsDco8h1MuLl5A3Trh1BomG8Id2yl"

*/
/*
export const handler = async(event) => {
    // TODO implement
    const response = {
        statusCode: 200,
        body: JSON.stringify('Hello from Lambda!'),
    };
    return response;
};
*/
const AWS = require("aws-sdk");
const sns = new AWS.SNS({apiVersion: '2010-03-31'});
const dynamodb = new AWS.DynamoDB({ apiVersion: "2012-08-10" });
const tableName = process.env.COURSE_TABLE;

const topicArn = process.env.TOPIC_ARN;
exports.handler = async (event) => {
    console.log("New message from a visitor: " + JSON.stringify(event));

    const invalidReq = {
        statusCode: 400,
        headers: {
            "Access-Control-Allow-Origin" : "*",
            "Access-Control-Allow-Credentials" : true
        },
        body: JSON.stringify('Invalid request')
    };

    if (event.httpMethod === "POST") {
        if (event.path === "/contact") {
            try {
                const body = JSON.parse(event.body);

                if (!body || !body.Email || !body.GuestName || !body.Message) {
                    console.log("Invalid request - Required params are missing.");
                    return invalidReq;
                }

                let emailSubject = `${body.GuestName} messaged you on unubold.com!`;

                const snsParams = {
                    Message: JSON.stringify({
                        subject: body.MessageTitle,
                        email: body.Email,
                        phone: body.Phone,
                        message: body.Message
                    }),
                    Subject: emailSubject,
                    TopicArn: topicArn
                };

                const res = await sns.publish(snsParams).promise();

                console.log("Successfully sent email: " + JSON.stringify(res));

                // Saving a message in the DB
                const saveParams = {
                    TableName: tableName,
                    Item: {
                        "MessageTitle": {
                            S: body.MessageTitle
                        },
                        "Email": {
                            S: body.Email
                        },
                        "Phone": {
                            S: body.Phone
                        },
                        "Message" :{
                            S: body.Message
                        },
                        "GuestName": {
                            S: body.GuestName
                        }
                    }
                };

                await dynamodb.putItem(saveParams).promise();

                return {
                    statusCode: 200,
                    headers: {
                        "Access-Control-Allow-Origin" : "*",
                        "Access-Control-Allow-Credentials" : true
                    },
                    body: JSON.stringify('Success')
                };

            } catch (err) {
                const msg = "System error while sending SNS or saving DynamoDB";

                console.log(msg + ": " + JSON.stringify(err));

                return {
                    statusCode: 500,
                    headers: {
                        "Access-Control-Allow-Origin" : "*",
                        "Access-Control-Allow-Credentials" : true
                    },
                    body: JSON.stringify(msg)
                };
            }
        } else {
            console.log("Invalid request - Wrong endpoint.");
            return invalidReq;
        }

    } else {
        console.log("Invalid request - Wrong http method.");
        return invalidReq;
    }
};
/*
"https://sqs.us-east-1.amazonaws.com/184492743795/messageForEmail.fifo"

"https://sqs.us-east-1.amazonaws.com/184492743795/messageForStorage.fifo"

SQS_MESSAGE_STORAGE_ARN

SQS_MESSAGE_EMAIL_ARN


{
    "GuestName": "Guest",
    "MessageTitle": "SAanMessageTitle",
    "Email": "sanjiv771@gmail.com",
    "Phone": "+1641233",
    "Message": "Hello world"
}
messageForEmail.fifo

ns-250.awsdns-31.com.
    ns-1449.awsdns-53.org.
    ns-736.awsdns-28.net.
    ns-1882.awsdns-43.co.uk.

{"guestName":"Guest","messageTitle":"SAanMessageTitle","email":"sanjiv771+89@gmail.com","phone":"+1641233","message":"Hello world Test"}",
*/
const AWS = require("aws-sdk");


var ses = new AWS.SES({ region: "us-east-1" });
/*
 * This function will send email through SES service
 */
exports.handler = async (event) => {
    console.log("Message from queue: " + JSON.stringify(event));
    let body = JSON.parse(event.Records[0].body);
    console.log(body);
    /*
    {
        "guestName": "Guest",
        "messageTitle": "SAanMessageTitle",
        "email": "sanjiv771@gmail.com",
        "phone": "+1641233",
        "message": "Hello world"
    }
    */
    try {
        /*
        const params = {
    Destination: {
        ToAddresses: [
            process.env.VERIFIED_EMAIL
        ]
      },
    Message: {
        Body: {
            Text: {
                Data: message,
                Charset: 'UTF-8'
            }
        },
        Subject: {
            Data: subject,
            Charset: 'UTF-8'
        }
    },
    Source: process.env.VERIFIED_EMAIL,
    ReplyToAddresses: [senderEmail]
  }
        */
        console.log(body);
        console.log(body.message)
        var params = {
            Destination: {
                ToAddresses: ["sanjiv.sarkar@miu.edu"],
            },
            Message: {
                Body: {
                    Text: { Data: body.message, Charset: 'UTF-8' },
                },

                Subject: { Data: body.messageTitle, Charset: 'UTF-8' },
            },
            Source: "sanjiv771@gmail.com"//process.env.SOURCE_EMAIL
        };
        console.log(params);
        ses.sendEmail(params, function(err, data) {
            if (err) console.log(err, err.stack); // an error occurred
            else     console.log(data);           // successful response
        });
        /*
        ses.sendEmail(params).promise().then(function(result) {
    console.log(result); // "initResolve"
    return "normalReturn";
  })
  .then(function(result) {
    console.log(result); // "normalReturn"
  });
  */
        //console.log(res);
        console.log("Successfully email sent");
    } catch (err) {
        const msg = "System error while sending email";

        console.log(msg + ": " + JSON.stringify(err));
    }
};

// Load the AWS SDK for Node.js
var aws = require('aws-sdk');

// Create a new SES object in ap-south-1 region
var ses = new aws.SES({region: 'us-east-1'});

exports.handler = (event, context, callback) => {
    console.log("Message from queue: " + JSON.stringify(event));
    let body = JSON.parse(event.Records[0].body);
    console.log(body);
    var params = {
        Destination: {
            ToAddresses: [process.env.RECEVIER_EMAIL]
        },
        Message: {
            Body: {
                Text: { Data: body.message

                }

            },

            Subject: { Data: body.guestName +": "+body.messageTitle

            }
        },
        Source: process.env.SOURCE_EMAIL,
        ReplyToAddresses: [body.email]
    };


    ses.sendEmail(params, function (err, data) {
        callback(null, {err: err, data: data});
        if (err) {
            console.log(err);
            context.fail(err);
        } else {

            console.log(data);
            context.succeed(event);
        }
    });
};

// Load the AWS SDK for Node.js
var aws = require('aws-sdk');

// Create a new SES object in ap-south-1 region
var ses = new aws.SES({region: 'us-east-1'});

exports.handler = (event, context, callback) => {
    console.log("Message from queue: " + JSON.stringify(event));
    let body = JSON.parse(event.Records[0].body);
    console.log(body);
    var params = {
        Destination: {
            ToAddresses: [process.env.RECEVIER_EMAIL]
        },
        Message: {
            Body: {
                Text: { Data: body.message

                }

            },

            Subject: { Data: body.guestName +": "+body.messageTitle

            }
        },
        Source: process.env.SOURCE_EMAIL,
        ReplyToAddresses: [body.email]
    };


    ses.sendEmail(params, function (err, data) {
        callback(null, {err: err, data: data});
        if (err) {
            console.log(err);
            context.fail(err);
        } else {

            console.log(data);
            context.succeed(event);
        }
    });
};
