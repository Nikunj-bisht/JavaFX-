const nodemailer=require('nodemailer');

const sendemail=async options=>{
//create transporter
const transporter=nodemailer.createTransport({
  service:'Gmail',
  auth:{
    user:process.env.Email_username,
    pass:process.env.Email_password
  }
  });
  var mailOptions = {
  from: process.env.Email_username,
  to: "akbisht1973.sundari@gmail.com",
  subject: 'Sending Email using Node.js',
  text: 'Hello from nikunj'
};
await transporter.sendMail(mailOptions);

};
module.exports=sendemail;
