Cloning a private Github repo to your EC2 Instance.
===================================================

[

![Rahul Padalkar](https://miro.medium.com/v2/resize:fill:88:88/0*Rmx7K-XUVPH0IrFx.)

](https://rahulnpadalkar.medium.com/?source=post_page---byline--f40c4db6a395--------------------------------)

[Rahul Padalkar](https://rahulnpadalkar.medium.com/?source=post_page---byline--f40c4db6a395--------------------------------)

[Follow](https://medium.com/m/signin?actionUrl=https%3A%2F%2Fmedium.com%2F_%2Fsubscribe%2Fuser%2F979f1ef30c81&operation=register&redirect=https%3A%2F%2Frahulnpadalkar.medium.com%2Fcloning-a-private-github-repo-to-your-ec2-instance-f40c4db6a395&user=Rahul+Padalkar&userId=979f1ef30c81&source=post_page-979f1ef30c81--byline--f40c4db6a395---------------------post_header-----------)

2 min read

[](https://medium.com/m/signin?actionUrl=https%3A%2F%2Fmedium.com%2F_%2Fvote%2Fp%2Ff40c4db6a395&operation=register&redirect=https%3A%2F%2Frahulnpadalkar.medium.com%2Fcloning-a-private-github-repo-to-your-ec2-instance-f40c4db6a395&user=Rahul+Padalkar&userId=979f1ef30c81&source=---header_actions--f40c4db6a395---------------------clap_footer-----------)

11

[](https://medium.com/m/signin?actionUrl=https%3A%2F%2Fmedium.com%2F_%2Fbookmark%2Fp%2Ff40c4db6a395&operation=register&redirect=https%3A%2F%2Frahulnpadalkar.medium.com%2Fcloning-a-private-github-repo-to-your-ec2-instance-f40c4db6a395&source=---header_actions--f40c4db6a395---------------------bookmark_footer-----------)

[](https://medium.com/m/signin?actionUrl=https%3A%2F%2Fmedium.com%2Fplans%3Fdimension%3Dpost_audio_button%26postId%3Df40c4db6a395&operation=register&redirect=https%3A%2F%2Frahulnpadalkar.medium.com%2Fcloning-a-private-github-repo-to-your-ec2-instance-f40c4db6a395&source=---header_actions--f40c4db6a395---------------------post_audio_button-----------)

![](https://miro.medium.com/v2/resize:fit:700/1*LM8i9zx9Rf5hSf2dCu72Og.png)

Create a public and private key using ssh-keygen
------------------------------------------------

SSH into your EC2 instance and run the command below. The email address here is your Github account email address.

sudo ssh-keygen -t rsa -C "your-email-address@gmail.com" -b 4096

Keys are generated in `/root/.ssh/id_rsa` (if you don't change the default input). The public one is suffixed with `.pub`

Move both the generated keys to `/home/ubuntu/.ssh`

Create a Deploy key
-------------------

Navigate to settings for the repo you want to clone. Click on Deploy Keys tab. You will be greeted with this wonderful screen.

![](https://miro.medium.com/v2/resize:fit:700/1*xhRGqAWIASXmasdOojB-1A.png)

Give your key a cool title and paste the public key you created earlier in the key section. Don't alter its contents! Hit Add key.

![](https://miro.medium.com/v2/resize:fit:700/1*vgM-CDpHT8yZEetSQAgTXw.png)

Make sure you are able to connect to Github now by running

ssh -vT git@github.com

In the outbound rules of the EC2 Instance edit the rules to allow connection to Github servers. Allow all traffic to make it simple.

Then run the clone command

git clone git@github.com:OrgName/your-repo.git

That's it! Thanks for reading!
